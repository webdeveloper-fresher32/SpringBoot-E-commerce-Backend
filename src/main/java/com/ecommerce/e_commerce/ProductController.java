package com.ecommerce.e_commerce;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")

public class ProductController {
    @Autowired
    private  ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductModel product){
        ProductModel savedProduct=productService.saveProduct(product);
        return  ResponseEntity.ok(savedProduct);
    }

    @GetMapping
    public  ResponseEntity<List<ProductModel>> getAllProducts(){
        List<ProductModel> products=productService.getAllProducts();
        return  ResponseEntity.ok(products);
    }

    @GetMapping("/{Id}")
    public  ResponseEntity<?> updateProduct(@PathVariable Long Id,@Valid @RequestBody ProductModel product){
        ProductModel updateproduct=productService.updateProduct(Id,product);
        return  updateproduct!=null?ResponseEntity.ok(updateproduct):ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{Id}")
    public  ResponseEntity<?> deleteProduct(@PathVariable Long Id){
        productService.deleteProduct(Id);
        return  ResponseEntity.noContent().build();
    }
}
