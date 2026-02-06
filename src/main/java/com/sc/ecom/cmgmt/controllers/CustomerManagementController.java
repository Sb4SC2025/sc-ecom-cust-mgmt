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
     *  Request method: GET and url path: http://localhost:8080/api/v1/customers
     * */
    @GetMapping
    public List<CustomerResponse> findAllCustomers() {
        System.out.print("findAllCustomers");
        return customerService.findAllCustomers();
        //return "Customer Details";
    }

    /**
     *  Request method: POST url path: http://localhost:8080/api/v1/customers
     * */
   // @RequestMapping(path = "/create", method = RequestMethod.POST)
    @PostMapping
    public  String createCustomer(@RequestBody CustomerRequest request){
        return customerService.createCustomer(request);
    }

    /**
     *  Request method: PUT url path: http://localhost:8080/api/v1/customers
     * */
    //@RequestMapping(path = "/modify", method = RequestMethod.PUT)
    @PutMapping
    public  String modifyCustomer(@RequestBody CustomerRequest request){
        System.out.println("modifyCustomer: " + request);
        return customerService.modifyCustomer(request);
    }

    /**
     *  Request method: DELETE url path: http://localhost:8080/api/v1/customers/{id}
     * */
    @DeleteMapping("/{id}")
    public String removeCustomerById(@PathVariable Long id){
        System.out.println("removeCustomerById");
        return customerService.removeCustomerById(id);
    }


    /**
     *  Request method: GET url path: http://localhost:8080/api/v1/customers/id/{id}
     * */
    @GetMapping("/id/{id}")
    public CustomerResponse findCustomerById(@PathVariable Long id) {
        System.out.println("findCustomerById");
        return customerService.findCustomerById(id);
    }

    /**
     *  Request method: GET url path: http://localhost:8080/api/v1/customers/address/{addr}
     * */
    @GetMapping("/addr/{addr}")
    public List<CustomerResponse> findCustomerByAddress(@PathVariable String addr) {
        System.out.println("findCustomerByAddress");
        return customerService.findCustomerByAddress(addr);
    }

    /**
     *  Request method: GET url path: http://localhost:8080/api/v1/customers/name/{name}
     * */
    @GetMapping("/name/{name}")
    public List<CustomerResponse> findCustomerByName(@PathVariable String name) {
        System.out.println("findCustomerByName");
        return customerService.findCustomerByName(name);
    }

}
