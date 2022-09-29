package com.robosoft.jpa.service;

import com.robosoft.jpa.modal.Product;
import com.robosoft.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> addProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }

    public Product update(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setName(product.getName());
        return productRepository.save(existingProduct);
    }

    public String deleteById(int id){
        productRepository.deleteById(id);
        return "Item Deleted";
    }

    public String deleteAll(){
        productRepository.deleteAll();
        return "All Items Deleted";
    }

}
