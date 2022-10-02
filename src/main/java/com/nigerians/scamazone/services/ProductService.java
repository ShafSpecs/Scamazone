package com.nigerians.scamazone.services;

import com.nigerians.scamazone.data.models.Product;
import com.nigerians.scamazone.data.models.Seller;
import com.nigerians.scamazone.data.respositories.ProductRepository;
import com.nigerians.scamazone.dtos.Requests.AddProductRequest;
import com.nigerians.scamazone.dtos.Requests.DeleteProductRequest;
import com.nigerians.scamazone.dtos.Requests.UpdateProductQuantityRequest;
import com.nigerians.scamazone.dtos.Requests.UpdateProductRequest;
import com.nigerians.scamazone.dtos.Responses.AddProductResponse;
import com.nigerians.scamazone.dtos.Responses.DeleteProductResponse;
import com.nigerians.scamazone.dtos.Responses.UpdateProductQuantityResponse;
import com.nigerians.scamazone.dtos.Responses.UpdateProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
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

        seller.getStore().getProduct().add(newProduct);

        userService.saveUser(seller);
        productRepository.save(newProduct);

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
    public Page<Product> getProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<Product> getProductsByCategory(String category, int page, int size) {
        return productRepository.findAllByCategory(category, PageRequest.of(page, size));
    }

    @Override
    public Page<Product> searchProducts(String query, int page, int size) {
        return productRepository.findAllByNameContaining(query, PageRequest.of(page, size));
    }

    @Override
    public Page<Product> getProductsByPriceBetween(double min, double max, int page, int size, String direction) {
        if(direction.equals("ASC")) {
            return productRepository.findAllByPriceBetween(min, max, PageRequest.of(page, size, Sort.by("price").ascending()));
        } else {
            return productRepository.findAllByPriceBetween(min, max, PageRequest.of(page, size, Sort.by("price").descending()));
        }
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
