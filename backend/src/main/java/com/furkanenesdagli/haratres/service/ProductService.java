package com.furkanenesdagli.haratres.service;

import com.furkanenesdagli.haratres.dto.AddProductRequestDto;
import com.furkanenesdagli.haratres.dto.ProductDto;
import com.furkanenesdagli.haratres.dto.UpdateProductRequestDto;
import com.furkanenesdagli.haratres.model.Product;

import java.util.List;

public interface ProductService {
    ProductDto addProduct(AddProductRequestDto product);
    List<ProductDto> getProducts();
    ProductDto getProductByid(Long id);
    Product getProductModelByid(Long id);
    ProductDto updateProduct(Long id, UpdateProductRequestDto product);

    void deleteProduct(Long id);

}
