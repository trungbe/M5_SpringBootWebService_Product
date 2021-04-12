package com.example.angular.repository;

import com.example.angular.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByOrderByIdAsc(Pageable pageable);
    @Query(value = "select  * from product where product.name like ?", nativeQuery = true)
    List<Product> findProductName(String name);

}
