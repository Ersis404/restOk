package com.example.rest.service;

import com.example.rest.model.OrderDetail;
import com.example.rest.repository.OrderDetailRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

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

    //public OrderDetail searchOrderDetail(Long order_id){
      //  Optional<OrderDetail> orderDetail = orderDetailRepository.findAll();
   // };
}
