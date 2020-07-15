package com.example.rest.api;

import com.example.rest.model.Orders;
import com.example.rest.model.OrderDetail;
import com.example.rest.service.OrderDetailService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @RequestMapping(value = "/delOrderDetail/{orderDetailId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void delOrder(@PathVariable("orderDetailId") Long orderDetailId){
        orderDetailService.delOrderDetail(orderDetailId);
    }

//    @RequestMapping(value = "/editOrder", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public void searchOrderDetail(@RequestBody Long order_id){
//        orderDetailService.searchOrderDetail(order_id);
//    }

    @RequestMapping(value = "/getAllOrderDetailByOrderId/{orderId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<OrderDetail> getAllOrderDetailByOrderId(@PathVariable("orderId") Long orderId){
        return orderDetailService.getAllOrderDetailByOrderId(orderId);
    }
}
