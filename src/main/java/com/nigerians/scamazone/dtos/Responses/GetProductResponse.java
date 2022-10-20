package com.nigerians.scamazone.dtos.Responses;

import com.nigerians.scamazone.data.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
@AllArgsConstructor
public class GetProductResponse {
    public int total;
    public Page<Product> products;
}
