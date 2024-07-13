package com.sb.sdjpa.crud.controller;

import com.sb.sdjpa.crud.request.ProductRequest;
import com.sb.sdjpa.crud.response.APIResponse;
import com.sb.sdjpa.crud.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * create a Product, in case of post mapping this method will get invoked.
     *
     * @param request product request
     * @return response entity object
     */
    @PostMapping("/create")
    public ResponseEntity<APIResponse> createProduct(@RequestBody ProductRequest request) {
        return productService.createCustomer(request);
    }

    /**
     * get all the products from the database, in case of get mapping with /getAll endpoint this method will get invoked.
     *
     * @return response entity object
     */
    @GetMapping("/getAll")
    public ResponseEntity<APIResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * get a specific product from the database, in case of get mapping with /getById endpoint this method will get invoked.
     *
     * @param productId customer id
     * @return response entity object
     */
    @GetMapping("/getById/{productId}")
    public ResponseEntity<APIResponse> getByProductId(@PathVariable long productId) {
        return productService.getByProductId(productId);
    }

}
