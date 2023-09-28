package com.fatihkarakus.ecommerce.service;

import com.fatihkarakus.ecommerce.dto.ProductDto;
import com.fatihkarakus.ecommerce.exceptions.ProductNotExistsException;
import com.fatihkarakus.ecommerce.model.Category;
import com.fatihkarakus.ecommerce.model.Product;
import com.fatihkarakus.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        productRepository.save(product);
    }

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setId(product.getId());

        return productDto;
    }

    public List<ProductDto> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();

        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product:allProducts) {
            productDtos.add(getProductDto(product));
        }

        return productDtos;
    }

    public void updateProduct(ProductDto productDto, Integer productId) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        // throw an exception if product does not exists
        if(!optionalProduct.isPresent()) {
            throw new Exception("product not present");
        }

        Product product = optionalProduct.get();
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }

    public Product findById(Integer productId) throws ProductNotExistsException {
        final Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()) {
            throw new ProductNotExistsException("product is invalid" + productId);
        }

        return optionalProduct.get();
    }
}
