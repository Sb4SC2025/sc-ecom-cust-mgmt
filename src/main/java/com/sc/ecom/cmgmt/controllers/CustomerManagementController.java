package com.sc.ecom.cmgmt.controllers;

import com.sc.ecom.cmgmt.requests.CustomerRequest;
import com.sc.ecom.cmgmt.responses.CustomerResponse;
import com.sc.ecom.cmgmt.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerManagementController {

    @Autowired
    private CustomerService customerService;

    /**
     *  Request url path: <a href="http://localhost:8080/api/v1/customers/info">info</a>
     * */
   // @RequestMapping(path = "/info", method = RequestMethod.GET)
    @GetMapping("/info")
    public String getCustomerInfo() {
        System.out.println("getCustomerInfo");
        return "Customer Information";
    }

    /**
     *  Request url path: <a href="http://localhost:8080/api/v1/customers/orders">orders</a>
     * */
   // @RequestMapping(path = "/orders", method = RequestMethod.GET)
    @GetMapping("/orders")
    public String getCustomerOrders() {
        System.out.println("getCustomerOrders");
        return "Customer Orders";
    }
    //@RequestMapping(path = "details", method=RequestMethod.GET)
    @GetMapping("/details")
    public List<CustomerResponse> getCustomerdetails() {
        System.out.print("getCustomerdetails");
        return customerService.findAllCustomers();
        //return "Customer Details";
    }

    /**
     *  Request url path: <a href="http://localhost:8080/api/v1/customers/create">create</a>
     * */
   // @RequestMapping(path = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public  String createCustomer(@RequestBody CustomerRequest request){
        return customerService.createCustomer(request);
    }

    /**
     *  Request url path: <a href="http://localhost:8080/api/v1/customers/modify">modify</a>
     * */
    //@RequestMapping(path = "/modify", method = RequestMethod.PUT)
    @PutMapping("/modify")
    public  String modifyCustomer(@RequestBody CustomerRequest request){
        System.out.println("modifyCustomer: " + request);
        return customerService.modifyCustomer(request);
    }

   // @RequestMapping(path = "/find/{id}", method = RequestMethod.GET)
    @GetMapping("/find/{id}")
    public CustomerResponse findCustomerById(@PathVariable Long id) {
        System.out.println("findCustomerById");
        return customerService.findCustomerById(id);
    }

   // @RequestMapping(path = "/remove/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/remove/{id}")
    public String removeCustomerById(@PathVariable Long id){
        System.out.println("removeCustomerById");
        return customerService.removeCustomerById(id);
    }

}
