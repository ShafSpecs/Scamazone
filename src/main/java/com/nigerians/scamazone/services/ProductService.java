package com.nigerians.scamazone.services;

import com.nigerians.scamazone.data.models.Product;
import com.nigerians.scamazone.data.models.Seller;
import com.nigerians.scamazone.data.respositories.ProductRepository;
import com.nigerians.scamazone.data.respositories.StoreRepository;
import com.nigerians.scamazone.dtos.Requests.AddProductRequest;
import com.nigerians.scamazone.dtos.Requests.DeleteProductRequest;
import com.nigerians.scamazone.dtos.Requests.UpdateProductQuantityRequest;
import com.nigerians.scamazone.dtos.Requests.UpdateProductRequest;
import com.nigerians.scamazone.dtos.Responses.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class ProductService implements iProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserService userService;

    @Override
    public AddProductResponse addProduct(AddProductRequest req) {
        Seller seller = (Seller) userService.getUser(Long.parseLong(req.getUserId()), "SELLER");

        Product newProduct = new Product();
        newProduct.setName(req.getName());
        newProduct.setDescription(req.getDescription());
        newProduct.setImage(req.getImage());
        newProduct.setPrice(req.getPrice());
        newProduct.setQuantity(req.getQuantity());
        newProduct.setCategory(req.getCategory());
        newProduct.setBrand(seller.getStore().getName());
        newProduct.setId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);

        seller.getStore().getProduct().add(newProduct);

        userService.saveUser(seller);

        return new AddProductResponse("Product added successfully", "SUCCESS", req.getUserId(), newProduct.getId().toString());
    }

    @Override
    public UpdateProductResponse updateProduct(UpdateProductRequest req) {
        Seller seller = (Seller) userService.getUser(Long.parseLong(req.getUserId()), "SELLER");

        Product product = seller.getStore().getProduct().stream().filter(p -> p.getId().toString().equals(req.getProductId())).findFirst().orElse(null);

        if (product == null) {
            return new UpdateProductResponse("Product not found", "FAILED", req.getUserId(), req.getProductId());
        }

        product.setName(req.getName());
        product.setDescription(req.getDescription());
        product.setImage(req.getImage());
        product.setPrice(req.getPrice());

        userService.saveUser(seller);
        productRepository.save(product);

        return new UpdateProductResponse("Product updated successfully", "SUCCESS", req.getUserId(), req.getProductId());
    }

    @Override
    public DeleteProductResponse deleteProduct(DeleteProductRequest req) {
        Seller seller = (Seller) userService.getUser(Long.parseLong(req.getUserId()), "SELLER");

        Product product = seller.getStore().getProduct().stream().filter(p -> p.getId().toString().equals(req.getProductId())).findFirst().orElse(null);

        if (product == null) {
            return new DeleteProductResponse("Product not found", "FAILED", req.getUserId());
        }

        seller.getStore().getProduct().remove(product);

        userService.saveUser(seller);
        productRepository.delete(product);

        return new DeleteProductResponse("Product deleted successfully", "SUCCESS", req.getUserId());
    }

    @Override
    public UpdateProductQuantityResponse updateProductStock(UpdateProductQuantityRequest req) {
        Seller seller = (Seller) userService.getUser(Long.parseLong(req.getUserId()), "SELLER");

        Product product = seller.getStore().getProduct().stream().filter(p -> p.getId().toString().equals(req.getProductId())).findFirst().orElse(null);

        if (product == null) {
            return new UpdateProductQuantityResponse("Product not found", "FAILED", req.getUserId(), req.getProductId());
        }

        product.setQuantity(req.getQuantity());

        userService.saveUser(seller);
        productRepository.save(product);

        return new UpdateProductQuantityResponse("Product quantity updated successfully", "SUCCESS", req.getUserId(), req.getProductId());
    }

    @Override
    public GetProductResponse getProducts(int page, int size) {
        int totalNumber = productRepository.findAll().size();
        Page<Product> products = productRepository.findAll(PageRequest.of(page, size));

        return new GetProductResponse(totalNumber, products);
    }

    @Override
    public GetProductResponse getProductsByCategory(String category, int page, int size) {
        int totalNumber = productRepository.findAllByCategory(category).size();
        Page<Product> products = productRepository.findAllByCategory(category, PageRequest.of(page, size));

        return new GetProductResponse(totalNumber, products);
    }

    @Override
    public GetProductResponse searchProducts(String query, int page, int size) {
        int totalNumber = productRepository.findAllByNameContaining(query).size();
        Page<Product> products = productRepository.findAllByNameContaining(query, PageRequest.of(page, size));

        return new GetProductResponse(totalNumber, products);
    }

    @Override
    public GetProductResponse getProductsByPriceBetween(double min, double max, int page, int size, String direction) {
        int totalNumber = productRepository.findAllByPriceBetween(min, max).size();
        Page<Product> products;

        if(direction.equals("ASC")) {
            products = productRepository.findAllByPriceBetween(min, max, PageRequest.of(page, size, Sort.by("price").ascending()));
            return new GetProductResponse(totalNumber, products);
        } else {
            products = productRepository.findAllByPriceBetween(min, max, PageRequest.of(page, size, Sort.by("price").descending()));
            return new GetProductResponse(totalNumber, products);
        }
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
