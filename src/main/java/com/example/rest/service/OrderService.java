package com.example.rest.service;


import com.example.rest.model.Orders;
import com.example.rest.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private final OrdersRepository ordersRepository;

    public OrderService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public void addNewOrder(Orders newOrders){
        ordersRepository.save(newOrders);

    }
    public void orderChange(Orders order){
        ordersRepository.save(order);
    }
    public void delOrder(Long ordersId){
        ordersRepository.deleteById(ordersId);
    }

    public Orders getOneOrderById(Long ordersId) {
        Optional<Orders> orders  = ordersRepository.findById(ordersId);
        return orders.get();
    }
}
