package com.acme.graphql.restclient;

import java.util.Arrays;
import java.util.List;

import com.acme.graphql.entity.History;
import com.acme.graphql.entity.Product;
import com.acme.graphql.entity.Sale;
import com.acme.graphql.properties.EcomerceUrl;
import com.acme.graphql.properties.StockUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author s2it_csilva
 * @version : $<br/>
 * : $
 * @since 11/16/19 11:32 AM
 */
@Component
public class RestCLient {

    private RestTemplate restTemplate;
    private HttpHeaders headers;

    @Autowired
    private EcomerceUrl ecomerceUrl;

    @Autowired
    private StockUrl stockUrl;


    public RestCLient(){
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public List<Product> getProducts (){
        HttpEntity<Product[]> entity = new HttpEntity<Product[]>(headers);
        ResponseEntity<Product[]> response
                = restTemplate.exchange(ecomerceUrl.getUrl() + "/product/list", HttpMethod.GET, entity, Product[].class);
        HttpStatus statusCode = response.getStatusCode();
        if (statusCode == HttpStatus.OK) {
            return Arrays.asList(response.getBody());
        }else{
            return null;
        }
    }

    public List<History> getHistory (final Long idProduct) {
        HttpEntity<History[]> entity = new HttpEntity<History[]>(headers);
        ResponseEntity<History[]> response
                = restTemplate.exchange(stockUrl.getUrl() + "/stock/history/" + idProduct, HttpMethod.GET, entity, History[].class);
        HttpStatus statusCode = response.getStatusCode();
        if (statusCode == HttpStatus.OK) {
            return Arrays.asList(response.getBody());
        }else{
            return null;
        }
    }

    public Product getProduct (final Long id) {
        HttpEntity<Product> entity = new HttpEntity<Product>(headers);
        ResponseEntity<Product> response
                = restTemplate.exchange(ecomerceUrl.getUrl() + "/product/" + id, HttpMethod.GET, entity, Product.class);
        HttpStatus statusCode = response.getStatusCode();
        if (statusCode == HttpStatus.OK) {
            return response.getBody();
        }else{
            return null;
        }
    }

    public Integer createProduct (final Product product) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Product> requestBody = new HttpEntity<>(product, headers);

        Integer idProduct = restTemplate.postForObject(stockUrl.getUrl() + "/stock/save/", requestBody, Integer.class);
        if (idProduct != null) {
            return idProduct;
        } else {
            return null;
        }
    }

    public Boolean saleProduct (final Sale sale) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Sale> requestBody = new HttpEntity<>(sale, headers);

        return restTemplate.postForObject(ecomerceUrl.getUrl() + "/checkout/sale", requestBody, Boolean.class);
    }
}
