package com.example.angular.controller;

import com.example.angular.model.Category;
import com.example.angular.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/category")
public class RestCategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public ResponseEntity<Iterable<Category>> getAll() {
        return new ResponseEntity<>(categoryService.findALl(), HttpStatus.OK);
    }

//    @PostMapping("/")
//    public ResponseEntity<Category> create(@RequestBody Category category) {
//        categoryService.save(category);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Category> delete(@PathVariable Long id){
//        categoryService.remove(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
