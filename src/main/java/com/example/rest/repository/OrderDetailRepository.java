package com.example.rest.repository;


import com.example.rest.model.OrderDetail;
import com.example.rest.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    ArrayList<OrderDetail> findAllByOrders(Orders orders);
}
