package com.nigerians.scamazone.services;

import com.nigerians.scamazone.data.models.Product;
import com.nigerians.scamazone.dtos.Requests.AddProductRequest;
import com.nigerians.scamazone.dtos.Requests.DeleteProductRequest;
import com.nigerians.scamazone.dtos.Requests.UpdateProductQuantityRequest;
import com.nigerians.scamazone.dtos.Requests.UpdateProductRequest;
import com.nigerians.scamazone.dtos.Responses.*;
import org.springframework.data.domain.Page;

public interface iProductService {
    AddProductResponse addProduct(AddProductRequest req);
    UpdateProductResponse updateProduct(UpdateProductRequest req);
    DeleteProductResponse deleteProduct(DeleteProductRequest req);
    UpdateProductQuantityResponse updateProductStock(UpdateProductQuantityRequest req);
    GetProductResponse getProducts(int page, int size);
    GetProductResponse getProductsByCategory(String category, int page, int size);
    GetProductResponse searchProducts(String query, int page, int size);
    GetProductResponse getProductsByPriceBetween(double min, double max, int page, int size, String direction);
    Product getProductById(String id);
}
