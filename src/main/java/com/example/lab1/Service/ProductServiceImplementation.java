package com.example.lab1.Service;

import com.example.lab1.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {
    private final List<Product> productList = new ArrayList<>() {{
        add(Product.builder()
                .id(1L)
                .color("green")
                .name("apple")
                .price(6.2)
                .date(new Date())
                .build());
        add(Product.builder()
                .id(2L)
                .color("yellow")
                .name("pineapple")
                .price(11.6)
                .date(new Date())
                .build());
        add(Product.builder()
                .id(3L)
                .color("white")
                .name("arrow")
                .price(3.2)
                .build());
        add(Product.builder()
                .id(4L)
                .color("black")
                .name("pen")
                .price(1.0)
                .date(new Date())
                .build());
    }};


    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public Product getById(Long id) {
        return productList.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Product save(Product product) {
        product.setId((long) (productList.size() + 1));
        product.setDate(new Date());
        if (product.getColor() != null && product.getName() != null && product.getPrice() != null) {
            productList.add(product);
            return product;
        }
        return null;
    }

    @Override
    public Product update(Long id, Product product) {
        Product updateProduct = productList.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        if (updateProduct != null) {
            if (product.getColor() != null && product.getName() != null && product.getPrice() != null) {
                updateProduct.setColor(product.getColor());
                updateProduct.setName(product.getName());
                updateProduct.setPrice(product.getPrice());
                return updateProduct;
            }
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        productList.removeIf(product -> product.getId().equals(id));
    }
}
