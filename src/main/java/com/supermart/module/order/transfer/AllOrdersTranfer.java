package com.supermart.module.order.transfer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AllOrdersTranfer {

    List<OrderDetailsTransfer> AllOrderDetailsList = new ArrayList<>();

}
