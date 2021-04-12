package com.example.angular.repository;

import com.example.angular.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends CrudRepository<Category, Long> {
}
