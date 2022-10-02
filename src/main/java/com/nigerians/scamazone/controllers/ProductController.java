package com.nigerians.scamazone.controllers;

import com.nigerians.scamazone.data.models.Product;
import com.nigerians.scamazone.dtos.Requests.AddProductRequest;
import com.nigerians.scamazone.dtos.Requests.DeleteProductRequest;
import com.nigerians.scamazone.dtos.Requests.UpdateProductQuantityRequest;
import com.nigerians.scamazone.dtos.Requests.UpdateProductRequest;
import com.nigerians.scamazone.dtos.Responses.AddProductResponse;
import com.nigerians.scamazone.dtos.Responses.DeleteProductResponse;
import com.nigerians.scamazone.dtos.Responses.UpdateProductQuantityResponse;
import com.nigerians.scamazone.dtos.Responses.UpdateProductResponse;
import com.nigerians.scamazone.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public AddProductResponse addProduct(AddProductRequest req) {
        return productService.addProduct(req);
    }

    @PatchMapping("/update")
    public UpdateProductResponse updateProduct(UpdateProductRequest req) {
        return productService.updateProduct(req);
    }

    @DeleteMapping("/delete")
    public DeleteProductResponse deleteProduct(DeleteProductRequest req) {
        return productService.deleteProduct(req);
    }

    @PatchMapping("/update/quantity")
    public UpdateProductQuantityResponse updateProductQuantity(UpdateProductQuantityRequest req) {
        return productService.updateProductStock(req);
    }

    @GetMapping("/get/products")
    public Page<Product> getProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return productService.getProducts(page, size);
    }

    @GetMapping("/get/products/category")
    public Page<Product> getProductsByCategory(@RequestParam String category, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return productService.getProductsByCategory(category, page, size);
    }

    @GetMapping("/get/products/search")
    public Page<Product> searchProducts(@RequestParam String query, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return productService.searchProducts(query, page, size);
    }

    @GetMapping("/get/products/price")
    public Page<Product> getProductsByPriceBetween(@RequestParam double min, @RequestParam double max, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "asc") String direction) {
        return productService.getProductsByPriceBetween(min, max, page, size, direction);
    }
}
