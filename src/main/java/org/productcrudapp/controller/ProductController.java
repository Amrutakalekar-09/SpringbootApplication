package org.productcrudapp.controller;

import java.util.List;

import org.productcrudapp.model.Product;
import org.productcrudapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService prodService;

    @PostMapping
    public String saveProduct(@RequestBody Product product) {
        boolean isAdded = prodService.isAddProduct(product);
        return isAdded ? "Product added successfully." : "Failed to add product.";
    }

    @GetMapping
    public List<Product> getAllProducts(@RequestParam(value = "page", required = false) Integer page) {
        return prodService.getAllProducts();
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Integer id) {
        Product product = prodService.getProductById(id);
        return product != null ? product.toString() : "Product not found.";
    }
    
    

    @PutMapping("/{id}")
    public String updateProduct(@RequestBody Product product, @PathVariable("id") Integer id) {
        String result = prodService.updateProduct(id, product);
        return result;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        String result = prodService.deleteProductById(id);
        return result;
    }
}
