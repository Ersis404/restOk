package com.example.rest.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/customer",produces = {MediaType.APPLICATION_JSON_VALUE})
public class ControllerCustomer {
//    private final CustomerService customerService;
//
//    @Autowired
//    public ControllerCustomer(CustomerService customerService) {
//        this.customerService = customerService;
//    }
}
