package com.sb.sdjpa.crud.mapper;

import com.sb.sdjpa.crud.model.ProductModel;
import com.sb.sdjpa.crud.request.ProductRequest;
import com.sb.sdjpa.crud.response.ProductResponse;

public class ProductMapper {
    public static ProductResponse modelToResponseMapper(ProductModel productModel) {
        return ProductResponse.builder()
                .productId(productModel.getProductId())
                .productName(productModel.getProductName())
                .productCategory(productModel.getProductCategory())
                .productPrice(productModel.getProductPrice())
                .createdDate(productModel.getCreatedDate())
                .updatedDate(productModel.getUpdatedDate())
                .build();
    }

    public static ProductModel requestToModel(ProductRequest request) {
        return ProductModel.builder()
                .productName(request.getProductName())
                .productCategory(request.getProductCategory())
                .productPrice(request.getProductPrice())
                .build();
    }
}
