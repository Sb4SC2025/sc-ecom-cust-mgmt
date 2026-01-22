package com.sc.ecom.cmgmt.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerManagementController {

    /**
     *  Request url path: <a href="http://localhost:8080/api/v1/customers/info">info</a>
     * */
    @RequestMapping(path = "/info", method = RequestMethod.GET)
    public String getCustomerInfo() {
        System.out.println("getCustomerInfo");
        return "Customer Information";
    }

    /**
     *  Request url path: <a href="http://localhost:8080/api/v1/customers/orders">orders</a>
     * */
    @RequestMapping(path = "/orders", method = RequestMethod.GET)
    public String getCustomerOrders() {
        System.out.println("getCustomerOrders");
        return "Customer Orders";
    }

}
