package com.example.rest.api;

import com.example.rest.model.Order;
import com.example.rest.model.OrderDetail;
import com.example.rest.service.OrderDetailService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/orderDetail",produces = {MediaType.APPLICATION_JSON_VALUE})
public class ControllerOrderDetail {
    private final OrderDetailService orderDetailService;

    public ControllerOrderDetail(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @RequestMapping(value = "/addNewOrderDetail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addNewOrderDetail(@RequestBody OrderDetail newOrderDetail){
        orderDetailService.addNewOrderDetail(newOrderDetail);
    }

    @RequestMapping(value = "/delOrderDetail/{orderId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void delOrder(@PathVariable("orderDetailId") Long orderDetailId){
        orderDetailService.delOrderDetail(orderDetailId);
    }
//
//    @RequestMapping(value = "/editOrder", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public void searchOrderDetail(@RequestBody Order newOrder){
//        orderDetailService.searchOrderDetail(newOrder);
//    }
}
