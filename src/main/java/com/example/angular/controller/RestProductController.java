package com.example.angular.controller;

import com.example.angular.model.Category;
import com.example.angular.model.Product;
import com.example.angular.service.category.ICategoryService;
import com.example.angular.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin("*")

@RestController
@RequestMapping("/products")
public class RestProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findALl();
    }

    @ModelAttribute("category")
    public Category category() {
        return new Category();
    }

    //show
    @GetMapping()
    public ResponseEntity<Iterable<Product>> findAll() {
        return new ResponseEntity<>(productService.findALl(), HttpStatus.OK);
    }

    //create
    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //findId
    @GetMapping("/{id}")
    public ResponseEntity<Product> getOneProduct(@PathVariable Long id) {
        Product p;
        p = productService.findById(id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    //update
    @PutMapping("/edit/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        productService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //search name product
//    @PostMapping("/searchName")
//    public ModelAndView searchProductByName(@RequestParam String name) {
//        name = "%" + name + "%";
//        List<Product> products = productService.findByName(name);
//        return new ModelAndView("listProduct", "list", products);
//    }

}
