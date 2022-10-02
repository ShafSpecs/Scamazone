package com.nigerians.scamazone.services;

import com.nigerians.scamazone.data.models.Product;
import com.nigerians.scamazone.dtos.Requests.AddProductRequest;
import com.nigerians.scamazone.dtos.Requests.DeleteProductRequest;
import com.nigerians.scamazone.dtos.Requests.UpdateProductQuantityRequest;
import com.nigerians.scamazone.dtos.Requests.UpdateProductRequest;
import com.nigerians.scamazone.dtos.Responses.AddProductResponse;
import com.nigerians.scamazone.dtos.Responses.DeleteProductResponse;
import com.nigerians.scamazone.dtos.Responses.UpdateProductQuantityResponse;
import com.nigerians.scamazone.dtos.Responses.UpdateProductResponse;
import org.springframework.data.domain.Page;

public interface iProductService {
    AddProductResponse addProduct(AddProductRequest req);
    UpdateProductResponse updateProduct(UpdateProductRequest req);
    DeleteProductResponse deleteProduct(DeleteProductRequest req);
    UpdateProductQuantityResponse updateProductStock(UpdateProductQuantityRequest req);
    Page<Product> getProducts(int page, int size);
    Page<Product> getProductsByCategory(String category, int page, int size);
    Page<Product> searchProducts(String query, int page, int size);
    Page<Product> getProductsByPriceBetween(double min, double max, int page, int size, String direction);
    Product getProductById(String id);
}
