package com.supermart.module.order.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.supermart.module.product.model.Product;
import com.supermart.module.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "order_items")
public class OrderItems implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Order.class)
    @JoinColumn(name = "order_id", insertable=false, updatable=false)
    Order order;

    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name = "product_id", insertable=false, updatable=false)
    Product product;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "item_price")
    int price;

    @Column(name = "quantity")
    Integer quantity;
}
