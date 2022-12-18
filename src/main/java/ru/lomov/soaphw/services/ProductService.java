package ru.lomov.soaphw.services;

import org.springframework.stereotype.Service;
import ru.lomov.soaphw.entities.ProductEntity;
import ru.lomov.soaphw.repositories.ProductRepository;
import ru.lomov.soaphw.soap.products.Product;


import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static final Function<ProductEntity, Product> functionEntityToSoap = productEntity -> {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setTitle(productEntity.getTitle());
        product.setPrice(productEntity.getPrice());
        return product;
    };

    public List<Product> findAllProduct(){
        return productRepository.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }
}
