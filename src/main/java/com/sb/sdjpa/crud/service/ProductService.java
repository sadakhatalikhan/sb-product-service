package com.sb.sdjpa.crud.service;

import com.sb.sdjpa.crud.request.ProductRequest;
import com.sb.sdjpa.crud.response.APIResponse;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<APIResponse> createCustomer(ProductRequest request);
    ResponseEntity<APIResponse> getAllProducts();
    ResponseEntity<APIResponse> getByProductId(long productId);
}
