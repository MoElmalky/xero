package com.meteora.xero.services;


import com.meteora.xero.api.model.Product;
import com.meteora.xero.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServices(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public Optional<Product> getProduct(Long id) {
        return this.productRepository.findById(id);
    }

    public Product addProduct(Product product) {
        return this.productRepository.save(product);
    }

    public List<Product> getByCategory(String category){
        return this.productRepository.findByCategory(category);
    }

    public List<Product> getByName(String name){
        return this.productRepository.findByName(name);
    }
}
