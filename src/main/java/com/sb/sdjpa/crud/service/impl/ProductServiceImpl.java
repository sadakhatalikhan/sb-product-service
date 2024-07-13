package com.sb.sdjpa.crud.service.impl;

import com.sb.sdjpa.crud.model.ProductModel;
import com.sb.sdjpa.crud.repository.ProductRepository;
import com.sb.sdjpa.crud.request.ProductRequest;
import com.sb.sdjpa.crud.response.APIResponse;
import com.sb.sdjpa.crud.response.ProductResponse;
import com.sb.sdjpa.crud.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sb.sdjpa.crud.constants.AppConstants.*;
import static com.sb.sdjpa.crud.mapper.ProductMapper.modelToResponseMapper;
import static com.sb.sdjpa.crud.mapper.ProductMapper.requestToModel;

/**
 * This class holds all the business logic, and it will be used as a interface between controller and DAO layer.
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    /**
     * This method is used to store the customer details into the database.
     *
     * @param request customer request
     * @return responseEntity object
     */
    @Override
    public ResponseEntity<APIResponse> createCustomer(ProductRequest request) {

        ProductModel productModel = productRepository.save(requestToModel(request));

        return ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(SUCCESS_CODE)
                        .errorMessage(SUCCESSFULLY_STORED)
                        .data(modelToResponseMapper(productModel))
                        .build()
        );
    }

    /**
     * This method is used to fetch all the customers from the database.
     *
     * @return responseEntity object
     */
    @Override
    public ResponseEntity<APIResponse> getAllProducts() {
        List<ProductModel> customerDetails = productRepository.findAll();
        List<ProductResponse> customers = customerDetails.stream()
                .map(productModel -> modelToResponseMapper(productModel))
                .toList();

        return ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(SUCCESS_CODE)
                        .errorMessage(SUCCESSFULLY_RETRIEVED)
                        .data(customers)
                        .build()
        );
    }

    /**
     * Fetch product based on the specific id.
     *
     * @param productId product id
     * @return responseEntity object
     */
    @Override
    public ResponseEntity<APIResponse> getByProductId(long productId) {
        Optional<ProductModel> modelOptional = productRepository.findById(productId);
        if (!modelOptional.isPresent()) {
            return ResponseEntity.ok(
                    APIResponse.builder()
                            .errorCode(CUSTOMER_NOT_EXISTS_CODE)
                            .errorMessage(CUSTOMER_NOT_EXISTS)
                            .data(List.of())
                            .build()
            );
        }

        ProductModel model = modelOptional.get();
        ProductResponse response = modelToResponseMapper(model);
        return ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(SUCCESS_CODE)
                        .errorMessage(SUCCESSFULLY_RETRIEVED)
                        .data(response)
                        .build()
        );
    }
}
