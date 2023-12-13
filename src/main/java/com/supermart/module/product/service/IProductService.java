package com.supermart.module.product.service;

import com.supermart.exception.FieldsRequiredException;
import com.supermart.model.RestResponce;
import com.supermart.module.product.model.Product;
import com.supermart.module.product.transfer.ProductRequestTransfer;
import com.supermart.module.product.transfer.ProductResponceTransfer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IProductService {

    String addProduct(ProductRequestTransfer productRequestTransfer) throws FieldsRequiredException;

    List<ProductRequestTransfer> getAllProducts();

    Optional<Product> getProduct(Long id);

}
