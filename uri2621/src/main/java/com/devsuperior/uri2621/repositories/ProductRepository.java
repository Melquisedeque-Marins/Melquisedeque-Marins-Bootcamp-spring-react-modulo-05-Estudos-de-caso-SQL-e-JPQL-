package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2621.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "SELECT products.name " +
            "FROM products " +
            "INNER JOIN providers ON products.id_provider = providers.id " +
            "WHERE providers.name LIKE CONCAT (:beginName, '%') " +
            "AND products.amount BETWEEN :min AND :max")
    List<ProductMinProjection> search1(Integer min, Integer max, String beginName);

     @Query(value = "SELECT new com.devsuperior.uri2621.dto.ProductMinDTO(obj.name) " +
            "FROM Product obj" +
            "WHERE obj.provider.name LIKE CONCAT (:beginName, '%') " +
            "AND obj.amount BETWEEN :min AND :max")
    List<ProductMinDTO> search2(Integer min, Integer max, String beginName);

}
