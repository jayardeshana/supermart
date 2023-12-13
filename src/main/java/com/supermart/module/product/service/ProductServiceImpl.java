package com.supermart.module.product.service;

import com.supermart.exception.FieldsRequiredException;
import com.supermart.exception.NotAcceptableException;
import com.supermart.model.RestResponce;
import com.supermart.module.product.model.Product;
import com.supermart.module.product.repository.ProductRepository;
import com.supermart.module.product.transfer.ProductRequestTransfer;
import com.supermart.module.product.transfer.ProductResponceTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public String addProduct(ProductRequestTransfer productRequestTransfer) throws FieldsRequiredException {
        if (productRequestTransfer.getCategory() == null ||
                productRequestTransfer.getName().isEmpty() ||
                productRequestTransfer.getUnit() == null
        ) {
            throw new NotAcceptableException(NotAcceptableException.NotAcceptableExceptionMSG.FIELD_NOT_PRESENT);
        }

        Product product = new Product();
        product.setCategory(productRequestTransfer.getCategory());
        product.setName(productRequestTransfer.getName());
        product.setPrice(productRequestTransfer.getPrice());
        product.setUnit(productRequestTransfer.getUnit());
        product.setProductImgUrl(productRequestTransfer.getProductImageUrl());
        product.setDescription(productRequestTransfer.getDescription());
        productRepository.save(product);
        return "Saved successfully";
    }

    @Override
    public List<ProductRequestTransfer> getAllProducts() {
      List<Product> listOfProducts = productRepository.findAllWithCategory();
      List<ProductRequestTransfer> productRequestTransferList = listOfProducts
              .stream().map( product -> {
                 ProductRequestTransfer productRequestTransfer = new ProductRequestTransfer();
                 productRequestTransfer.setName(product.getName());
                 productRequestTransfer.setUnit(product.getUnit());
                 productRequestTransfer.setCategory(product.getCategory());
                 productRequestTransfer.setPrice(product.getPrice());
                 productRequestTransfer.setDescription(product.getDescription());
                 productRequestTransfer.setProductImageUrl(product.getProductImgUrl());
                 return productRequestTransfer;
              }).collect(Collectors.toList());
      return productRequestTransferList;
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }
}
