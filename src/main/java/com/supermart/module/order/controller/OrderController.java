package com.supermart.module.order.controller;

import com.supermart.exception.FieldsRequiredException;
import com.supermart.model.RestResponce;
import com.supermart.module.order.service.IOrderService;
import com.supermart.module.order.transfer.AllOrdersTranfer;
import com.supermart.module.order.transfer.OrderDetailsTransfer;
import com.supermart.module.order.transfer.OrderRequestTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.TreeUI;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @PostMapping("/{userId}")
    RestResponce createOrder(@RequestBody List<OrderRequestTransfer> orderRequestTransferList, @PathVariable Long userId){
        String responce = orderService.createOrder(orderRequestTransferList, userId);
        return new RestResponce(responce);
    }

    @GetMapping("/get-order-by-id/{orderId}")
    RestResponce getOrderById(@PathVariable Long orderId) throws FieldsRequiredException {
       OrderDetailsTransfer orderDetailsTransfer = orderService.getOrderDetails(orderId);
        return new RestResponce(true, orderDetailsTransfer);
    }

    @GetMapping("/get-all-orders/{mobile}")
    RestResponce getOrdersByMobile(@PathVariable String mobile) throws FieldsRequiredException {
       AllOrdersTranfer allOrdersTranfer = orderService.getAllOrdersByMobile(mobile);
        return new RestResponce(allOrdersTranfer);
    }

}
