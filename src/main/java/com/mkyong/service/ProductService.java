package com.mkyong.service;

import com.mkyong.model.Product;
import com.mkyong.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll(){
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product getbyId(Integer id) throws Exception {
        Optional<Product> optionProduct = productRepository.findById(id);
        Product product = optionProduct.get();
        return product;
    }

    public List<Product> search(String name){
        List<Product> products = productRepository.search(name);
        return products;
    }

}
