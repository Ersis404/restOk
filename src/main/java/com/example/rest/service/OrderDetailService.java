package com.example.rest.service;

import com.example.rest.model.OrderDetail;
import com.example.rest.model.Orders;
import com.example.rest.repository.OrderDetailRepository;

import com.example.rest.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderDetailService {
    public final OrderDetailRepository orderDetailRepository;
    public final OrdersRepository ordersRepository;

    public OrderDetailService(OrderDetailRepository orderDetailRepository, OrdersRepository ordersRepository) {
        this.orderDetailRepository = orderDetailRepository;
        this.ordersRepository = ordersRepository;
    }

    public void addNewOrderDetail(OrderDetail newOrderDetail) {
        OrderDetail orderDetail = newOrderDetail;
        orderDetail.setPrice(orderDetail.getProduct().getPrice());
        orderDetailRepository.save(orderDetail);
    }

    public void delOrderDetail(Long orderDetailId) {
        orderDetailRepository.deleteById(orderDetailId);
    }

    public ArrayList<OrderDetail> getAllOrderDetailByOrderId(Long orderId) {
        Orders orders = ordersRepository.findById(orderId).get();
        return orderDetailRepository.findAllByOrders(orders);
    }

}
