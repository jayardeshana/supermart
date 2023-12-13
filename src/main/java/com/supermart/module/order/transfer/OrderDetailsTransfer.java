package com.supermart.module.order.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.supermart.module.order.model.OrderItems;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDetailsTransfer implements Serializable {

    Long OrderId;

    int orderAmount;

    List<OrderItemsTransfer> orderItemsTransferList = new ArrayList<>();

    OffsetDateTime orderDate;

}
