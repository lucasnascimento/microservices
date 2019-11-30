package com.acme.ecommerce.repository;

import com.acme.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author s2it_csilva
 * @version : $<br/>
 * : $
 * @since 9/27/19 1:22 PM
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}


