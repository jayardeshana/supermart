package com.supermart.module.product.controller;

import com.supermart.exception.FieldsRequiredException;
import com.supermart.model.RestResponce;
import com.supermart.module.product.model.Product;
import com.supermart.module.product.service.IProductService;
import com.supermart.module.product.transfer.ProductRequestTransfer;
import com.supermart.module.product.transfer.ProductResponceTransfer;
import lombok.Lombok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    IProductService productService;

    @PostMapping("/add")
    public RestResponce addProduct(@RequestBody ProductRequestTransfer productRequestTransfer) throws FieldsRequiredException {
        String responce = productService.addProduct(productRequestTransfer);
        return new RestResponce(responce);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ProductRequestTransfer>> getAllProducts() {
        List<ProductRequestTransfer> productsList = productService.getAllProducts();
        System.out.println(productsList);
        return new ResponseEntity<>(productsList, HttpStatus.OK);
    }


    @GetMapping("/get-product/{id}")
    public RestResponce getProductById(@PathVariable Long id){

        Optional<Product> product = productService.getProduct(id);

        if (product.isPresent()){
            return new RestResponce(true, product);
        }else {
            return new RestResponce("product not found");
        }
    }


}
