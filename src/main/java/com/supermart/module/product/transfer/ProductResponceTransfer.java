package com.supermart.module.product.transfer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supermart.enums.Unit;
import com.supermart.module.product.model.Category;
import lombok.Data;

import java.math.BigInteger;

@Data
public class ProductResponceTransfer {

    private String name;

    @JsonIgnore
    private Category category;

    private BigInteger price;

    private Unit unit;
}
