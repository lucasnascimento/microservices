package com.acme.ecommerce.services;

import static com.acme.ecommerce.converters.ProductConverter.toDTO;
import static com.acme.ecommerce.converters.ProductConverter.toSaleDTO;

import java.util.List;
import java.util.Optional;

import com.acme.ecommerce.constants.RabbitConstants;
import com.acme.ecommerce.converters.ProductConverter;
import com.acme.ecommerce.dtos.ProductDTO;
import com.acme.ecommerce.entities.Product;
import com.acme.ecommerce.exceptions.EstockInsufficientException;
import com.acme.ecommerce.exceptions.ProductNotFoundException;
import com.acme.ecommerce.repository.ProductRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author s2it_csilva
 * @version : $<br/>
 * : $
 * @since 9/27/19 1:23 PM
 */
@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public List<ProductDTO> listAll(){
        return toDTO(productRepository.findAll());
    }

    public ProductDTO saleProduct (final Long productId, final int amount) {
        Optional<Product> checkProduct = productRepository.findById(productId);
        return setSale(amount, checkProduct);
    }

    private ProductDTO setSale (final Integer quantity, final Optional<Product> checkProduct) {
        if(checkProduct.isPresent()){
            Product product = checkProduct.get();
            if(product.getStock() >= quantity){
                product.setStock(product.getStock() -  quantity);
                productRepository.save(product);
                rabbitTemplate.convertAndSend(RabbitConstants.SALE_EX, "", toSaleDTO(quantity, product.getId()));
                return toDTO(product);
            }else{
                throw new EstockInsufficientException();
            }
        }else{
            throw new ProductNotFoundException();
        }
    }

    public ProductDTO getProduct (final Long idProduct) {
        Optional<Product> product = productRepository.findById(idProduct);
        if(product.isPresent()){
            return ProductConverter.toDTO(product.get());
        }else{
            return null;
        }
    }

    @RabbitListener(queues = RabbitConstants.PRODUCT_QUEUE)
    public void getProducts(Product product){
        productRepository.save(product);
    }
}
