package com.supermart.module.order.transfer;

import com.supermart.module.product.model.Category;
import lombok.Data;

@Data
public class OrderItemsTransfer {
    Long productId;
    String productName;
    int orderItemPrice;
    int quantity;
    String category;
    int totalPrice;

}
