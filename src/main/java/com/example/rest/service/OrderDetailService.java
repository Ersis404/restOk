package com.example.rest.service;

import com.example.rest.model.OrderDetail;
import com.example.rest.model.Orders;
import com.example.rest.model.Product;
import com.example.rest.repository.OrderDetailRepository;

import com.example.rest.repository.OrdersRepository;
import com.example.rest.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderDetailService {
    public final OrderDetailRepository orderDetailRepository;
    public final OrdersRepository ordersRepository;
    public final ProductRepository productRepository;

    public OrderDetailService(OrderDetailRepository orderDetailRepository, OrdersRepository ordersRepository, ProductRepository productRepository) {
        this.orderDetailRepository = orderDetailRepository;
        this.ordersRepository = ordersRepository;
        this.productRepository = productRepository;
    }

    public void addNewOrderDetail(OrderDetail newOrderDetail) {
        OrderDetail orderDetail = newOrderDetail;
        Product product = productRepository.findById(newOrderDetail.getProduct().getId()).get();
        orderDetail.setPrice(product.getPrice());
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
