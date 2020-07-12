package com.example.rest.service;

import com.example.rest.model.Order;
import com.example.rest.model.OrderDetail;
import com.example.rest.repository.OrderDetailRepository;
import com.example.rest.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    public final OrderDetailRepository orderDetailRepository;

    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public void addNewOrderDetail(OrderDetail newOrderDetail) {
        orderDetailRepository.save(newOrderDetail);
    }

    public void delOrderDetail(Long orderDetailId) {
        orderDetailRepository.deleteById(orderDetailId);
    }

    public void searchOrderDetail(){

    };
}
