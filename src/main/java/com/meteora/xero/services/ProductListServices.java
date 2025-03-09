package com.meteora.xero.services;

import com.meteora.xero.api.model.ProductListModel;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductListServices {
    private final List<ProductListModel> products;

    public ProductListServices() {
        products = new ArrayList<>();

        products.add(new ProductListModel(1, "Tesla", 2, 20000, "Tesla electric car", 12, "AI"));
        products.add(new ProductListModel(2, "Phone", 4, 3000, "Apple iPhone", 13, "Gaming"));
        products.add(new ProductListModel(3, "TV", 3, 200, "Smart TV", 15, "Gaming"));
        products.add(new ProductListModel(4, "Refrigerator", 6, 400, "Modern Refrigerator", 12, "AI"));
        products.add(new ProductListModel(5, "Samsung 75", 4, 3000, "8K QLED Smart TV", 13, "Gaming"));
        products.add(new ProductListModel(6, "PlayStation 5", 4, 600, "Sony Gaming Console", 12, "Gaming"));
        products.add(new ProductListModel(7, "Dell XPS 15", 2, 500, "Windows Laptop", 18, "Working"));
        products.add(new ProductListModel(8, "Mirrorless Camera", 1, 2800, "Professional Camera", 12, "PG"));
        products.add(new ProductListModel(9, "Apple Watch", 200, 500, "Smartwatch", 16, "AI"));
        products.add(new ProductListModel(10, "Ahmed", 2, 400, "Example product", 12, "AI"));
    }


    public List<String> getProductsByCategory(String category) {
        return products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .map(ProductListModel::getProductName)
                .collect(Collectors.toList());
    }
}
