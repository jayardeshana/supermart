package com.supermart.module.product.transfer;

import com.supermart.enums.Unit;
import com.supermart.module.product.model.Category;
import lombok.Data;
import java.math.BigInteger;

@Data
public class ProductRequestTransfer {
    private String name;
    private Category category;
    private int price;
    private Unit unit;
    private String description;
    private String productImageUrl;
}
