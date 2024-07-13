package com.sb.sdjpa.crud.repository;

import com.sb.sdjpa.crud.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
