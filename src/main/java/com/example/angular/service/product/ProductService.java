package com.example.angular.service.product;

import com.example.angular.model.Product;
import com.example.angular.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findALl() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findALl(Pageable pageable) {
        return productRepository.findAllByOrderByIdAsc(pageable);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findProductName(name);
    }

}
