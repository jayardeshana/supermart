package com.supermart.module.order.service;

import com.supermart.exception.FieldsRequiredException;
import com.supermart.module.order.transfer.AllOrdersTranfer;
import com.supermart.module.order.transfer.OrderDetailsTransfer;
import com.supermart.module.order.transfer.OrderRequestTransfer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService {
    String createOrder(List<OrderRequestTransfer> orderRequestTransferList,  Long userId);

    OrderDetailsTransfer getOrderDetails(Long orderId) throws FieldsRequiredException;

    AllOrdersTranfer getAllOrdersByMobile(String mobile) throws FieldsRequiredException;
}
