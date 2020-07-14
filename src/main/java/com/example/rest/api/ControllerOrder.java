package com.example.rest.api;


import com.example.rest.model.Customer;
import com.example.rest.model.Order_status;
import com.example.rest.model.Orders;
import com.example.rest.model.Payment_method;
import com.example.rest.repository.CustomerRepository;
import com.example.rest.repository.OrdersRepository;
import com.example.rest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api/orders",produces = {MediaType.APPLICATION_JSON_VALUE})
public class ControllerOrder {
    private final OrderService orderService;
    private final OrdersRepository ordersRepository;
    private final CustomerRepository customerRepository;
    @Autowired
    public ControllerOrder(OrderService orderService, OrdersRepository ordersRepository, CustomerRepository customerRepository){
        this.orderService = orderService;
        this.ordersRepository = ordersRepository;
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/addNewOrders", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addNewOrder(@RequestBody Orders newOrders){
        orderService.addNewOrder(newOrders);
    }

    @RequestMapping(value = "/delOrders/{ordersId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void delOrder(@PathVariable("ordersId") Long orderId){
        orderService.delOrder(orderId);
    }

    @RequestMapping(value = "/editOrders", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void editOrder(@RequestBody Orders orders){
        orderService.orderChange(orders);
    }

    @RequestMapping(value = "/getOneOrderById/{ordersId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Orders getOneOrderById(@PathVariable("ordersId") Long ordersId){
        return orderService.getOneOrderById(ordersId);
    }

//    @PostConstruct
//    private void init(){
////        this.customerRepository.save(new Customer("Rdsd","dgdfgdf","dsfsdfs","dfsdfs","sdfsfsd","dfsfsfsdf"));
//        this.ordersRepository.save(new Orders(LocalDate.now(), Order_status.valueOf("created"), Payment_method.valueOf("CREDIT_CARD"),  this.customerRepository.save(new Customer("Rdsd","dgdfgdf","dsfsdfs","dfsdfs","sdfsfsd","dfsfsfsdf"))));
//    }
}
