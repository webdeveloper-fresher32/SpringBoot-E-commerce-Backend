package com.ecommerce.e_commerce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ProductRepo extends JpaRepository<ProductModel,Long> {

}
