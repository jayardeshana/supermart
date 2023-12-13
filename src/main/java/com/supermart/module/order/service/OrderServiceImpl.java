package com.supermart.module.order.service;

import com.supermart.exception.FieldsRequiredException;
import com.supermart.exception.NotAcceptableException;
import com.supermart.exception.NotFoundException;
import com.supermart.model.RestResponce;
import com.supermart.module.order.model.Order;
import com.supermart.module.order.model.OrderItems;
import com.supermart.module.order.repository.OrderItemRepository;
import com.supermart.module.order.repository.OrderRepository;
import com.supermart.module.order.transfer.AllOrdersTranfer;
import com.supermart.module.order.transfer.OrderDetailsTransfer;
import com.supermart.module.order.transfer.OrderItemsTransfer;
import com.supermart.module.order.transfer.OrderRequestTransfer;
import com.supermart.module.product.model.Product;
import com.supermart.module.product.repository.ProductRepository;
import com.supermart.module.user.model.User;
import com.supermart.module.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOError;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public String createOrder(List<OrderRequestTransfer> orderRequestTransferList, Long userId) {

        if (orderRequestTransferList.isEmpty() || userId == null){
            return "Field is mandatory";
        }

        int totalAmount = 0;

        for (OrderRequestTransfer orderRequestTransferobj: orderRequestTransferList){
             Product product = productRepository.findById(orderRequestTransferobj.getProductId()).get();
             int totalAmountOfItem = 0;
             totalAmountOfItem =  orderRequestTransferobj.getQuantity() * product.getPrice();
             totalAmount = totalAmount + totalAmountOfItem;
        }
        Order order = new Order();
        order.setOrderAmount(totalAmount);
        order.setUserId(userId);
        orderRepository.save(order);

        for (OrderRequestTransfer orderRequestTransferobj: orderRequestTransferList){
            Product product = productRepository.findById(orderRequestTransferobj.getProductId()).get();
            OrderItems orderItems = new OrderItems();
            orderItems.setProductId(product.getId());
            orderItems.setProduct(product);
            orderItems.setQuantity(orderRequestTransferobj.getQuantity());
            orderItems.setPrice(product.getPrice());
            orderItems.setOrderId(order.getId());
            orderItemRepository.save(orderItems);
        }

        return "order placed";
    }

    @Override
    public OrderDetailsTransfer getOrderDetails(Long orderId) throws FieldsRequiredException {

        if (orderId == null){
            throw new FieldsRequiredException("Order id should not be blanked !!");
        }

        List<OrderItems> orderItemsList = orderItemRepository.findByOrderId(orderId);

        List<OrderItemsTransfer> orderItemsTransferList = orderItemsList.stream().map(
                orderItems -> {
                 OrderItemsTransfer orderItemsTransfer = new OrderItemsTransfer();
                 orderItemsTransfer.setProductName(orderItems.getProduct().getName());
                 orderItemsTransfer.setOrderItemPrice(orderItems.getPrice());
                 orderItemsTransfer.setQuantity(orderItems.getQuantity());
                 orderItemsTransfer.setCategory(orderItems.getProduct().getCategory().getName());
                 orderItemsTransfer.setTotalPrice(orderItems.getPrice() * orderItems.getQuantity());
                 orderItemsTransfer.setProductId(orderItems.getProduct().getId());
                 return orderItemsTransfer;
                }
        ).collect(Collectors.toList());

        OrderDetailsTransfer orderDetailsTransfer = new OrderDetailsTransfer();
        Order order = orderRepository.findById(orderId).get();
        orderDetailsTransfer.setOrderAmount(order.getOrderAmount());
        orderDetailsTransfer.setOrderId(orderId);
        orderDetailsTransfer.setOrderItemsTransferList(orderItemsTransferList);
        orderDetailsTransfer.setOrderDate(order.getCreated());
        return orderDetailsTransfer;

    }

    @Override
    public AllOrdersTranfer getAllOrdersByMobile(String mobile) throws FieldsRequiredException {
        if (mobile.length() < 10) {
            throw new NotAcceptableException(NotAcceptableException.NotAcceptableExceptionMSG.MOBILE_INVALID);
        }
        User user = userRepository.findByMobile(mobile);
        if (user == null) {
            throw new NotFoundException(NotFoundException.UserNotFound.USER_NOT_FOUND);
        }
        List<Order> orderList = orderRepository.findByuserId(user.getId());
        List<OrderDetailsTransfer> orderDetailsTransferList = new ArrayList<>();
        for (Order order: orderList){
            OrderDetailsTransfer orderDetailsTransfer = getOrderDetails(order.getId());
            orderDetailsTransferList.add(orderDetailsTransfer);
        }

        AllOrdersTranfer allOrdersTranfer = new AllOrdersTranfer();
        allOrdersTranfer.setAllOrderDetailsList(orderDetailsTransferList);
        return allOrdersTranfer;
    }


}
