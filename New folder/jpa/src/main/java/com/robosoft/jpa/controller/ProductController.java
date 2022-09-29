package com.robosoft.jpa.controller;

import com.robosoft.jpa.modal.Product;
import com.robosoft.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product pr=productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(pr);
    }

    @PostMapping("/addProducts")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products) {
       List<Product> pList=productService.addProducts(products);
       return ResponseEntity.status(HttpStatus.CREATED).body(pList);
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product pr =productService.getProductById(id);
        if(pr!=null)
            return ResponseEntity.status(HttpStatus.FOUND).body(pr);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> pList=productService.getProducts();
        if(pList.size()==0)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.status(HttpStatus.FOUND).body(pList);
    }

    @GetMapping("/getProductByName/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        Product pr=productService.getProductByName(name);
        if(pr!=null)
            return ResponseEntity.status(HttpStatus.FOUND).body(pr);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/update")
    public ResponseEntity<Product> update(@RequestBody Product product) {
        Product pr=productService.update(product);
        if(pr==null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.status(HttpStatus.OK).body(pr);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        String str=productService.deleteById(id);
        if(str.equals("Item Deleted"))
            return ResponseEntity.status(HttpStatus.OK).body(str);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll(){
        String str=productService.deleteAll();
        if(str.equals("All Items Deleted"))
            return ResponseEntity.status(HttpStatus.OK).body(str);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
