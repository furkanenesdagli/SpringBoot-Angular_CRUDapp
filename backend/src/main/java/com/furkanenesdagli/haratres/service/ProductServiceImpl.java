package com.furkanenesdagli.haratres.service;

import com.furkanenesdagli.haratres.dto.AddProductRequestDto;
import com.furkanenesdagli.haratres.dto.ProductDto;
import com.furkanenesdagli.haratres.dto.UpdateProductRequestDto;
import com.furkanenesdagli.haratres.mapper.ProductMapper;
import com.furkanenesdagli.haratres.model.Product;
import com.furkanenesdagli.haratres.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto addProduct(AddProductRequestDto product) {
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setStock(product.getStock());
        newProduct.setDescription(product.getDescription());
        Product savedProduct = productRepository.save(newProduct);
        return ProductMapper.entityToDto(savedProduct);
    }

    @Override
    public List<ProductDto> getProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(ProductMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductByid(Long id) {
        Product product = getProductModelByid(id);
        if (product != null) {
            return ProductMapper.entityToDto(product);
        }
        return null;
    }

    @Override
    public Product getProductModelByid(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ProductDto updateProduct(Long id, UpdateProductRequestDto product) {
        Product productToUpdate = productRepository.findById(id).orElse(null);
        if (productToUpdate != null) {
            productToUpdate.setName(product.getName());
            productToUpdate.setPrice(product.getPrice());
            productToUpdate.setStock(product.getStock());
            productToUpdate.setDescription(product.getDescription());
            Product updatedProduct = productRepository.save(productToUpdate);
            return ProductMapper.entityToDto(updatedProduct);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

