package com.ecommerce.e_commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public ProductModel saveProduct(ProductModel product){
        return  productRepo.save(product);
    }

    public List<ProductModel> getAllProducts(){
        return  productRepo.findAll();
    }
    public Optional<ProductModel> getProductById(Long Id){
        return  productRepo.findById(Id);
    }

    public  ProductModel updateProduct(Long Id,ProductModel product){
        if(productRepo.existsById(Id)){
            product.setId(Id);
            return  productRepo.save(product);
        }else{
            return  null;
        }
    }
    public String deleteProduct(Long Id){
        productRepo.deleteById(Id);
        return  "Product Deleted successfully";
    }
}
