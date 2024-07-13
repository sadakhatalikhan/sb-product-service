package com.sb.sdjpa.crud.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public class ProductResponse {
    private Long productId;
    private String productName;
    private String productCategory;
    private String productPrice;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
