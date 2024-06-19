package com.furkanenesdagli.haratres.mapper;

import com.furkanenesdagli.haratres.dto.ProductDto;
import com.furkanenesdagli.haratres.dto.UpdateProductRequestDto;
import com.furkanenesdagli.haratres.model.Product;


public class ProductMapper {

    public static ProductDto entityToDto(Product savedProduct) {
        ProductDto dto = new ProductDto();
        dto.setId(savedProduct.getId());
        dto.setName(savedProduct.getName());
        dto.setPrice(savedProduct.getPrice());
        dto.setStock(savedProduct.getStock());
        dto.setDescription(savedProduct.getDescription());
        dto.setReviewpoint(savedProduct.getReviewpoint());
        return dto;
    }

    public static Product dtoToEntity(UpdateProductRequestDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setDescription(dto.getDescription());
        return product;
    }

    public static Product dtoToEntity(ProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setDescription(dto.getDescription());
        return product;
    }
}
