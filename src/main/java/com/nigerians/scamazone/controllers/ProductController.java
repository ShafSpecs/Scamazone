package com.nigerians.scamazone.controllers;

import com.nigerians.scamazone.data.models.Product;
import com.nigerians.scamazone.dtos.Requests.AddProductRequest;
import com.nigerians.scamazone.dtos.Requests.DeleteProductRequest;
import com.nigerians.scamazone.dtos.Requests.UpdateProductQuantityRequest;
import com.nigerians.scamazone.dtos.Requests.UpdateProductRequest;
import com.nigerians.scamazone.dtos.Responses.*;
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
    public AddProductResponse addProduct(@RequestBody AddProductRequest req) {
        return productService.addProduct(req);
    }

    @PatchMapping("/update")
    public UpdateProductResponse updateProduct(@RequestBody UpdateProductRequest req) {
        return productService.updateProduct(req);
    }

    @DeleteMapping("/delete")
    public DeleteProductResponse deleteProduct(@RequestBody DeleteProductRequest req) {
        return productService.deleteProduct(req);
    }

    @PatchMapping("/update/quantity")
    public UpdateProductQuantityResponse updateProductQuantity(@RequestBody UpdateProductQuantityRequest req) {
        return productService.updateProductStock(req);
    }

    @GetMapping("/get/products")
    public GetProductResponse getProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return productService.getProducts(page, size);
    }

    @GetMapping("/get/products/category")
    public GetProductResponse getProductsByCategory(@RequestParam String category, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return productService.getProductsByCategory(category, page, size);
    }

    @GetMapping("/get/products/search")
    public GetProductResponse searchProducts(@RequestParam String query, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return productService.searchProducts(query, page, size);
    }

    @GetMapping("/get/products/price")
    public GetProductResponse getProductsByPriceBetween(@RequestParam double min, @RequestParam double max, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "asc") String direction) {
        return productService.getProductsByPriceBetween(min, max, page, size, direction);
    }
}
