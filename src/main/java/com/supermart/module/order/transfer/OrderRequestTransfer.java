package com.supermart.module.order.transfer;

import lombok.Data;

@Data
public class OrderRequestTransfer {
    Long productId;
    int quantity;
}
