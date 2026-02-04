package com.sc.ecom.cmgmt.services;


import com.sc.ecom.cmgmt.requests.CustomerRequest;
import com.sc.ecom.cmgmt.responses.CustomerResponse;

import java.util.List;

public interface CustomerService {
    public String createCustomer(CustomerRequest request);
    public String modifyCustomer(CustomerRequest request);
    public CustomerResponse findCustomerById(Long id);
    public String removeCustomerById(Long id);

    public List<CustomerResponse> findAllCustomers();

    public List<CustomerResponse> findCustomerByAddress(String addr);

    public List<CustomerResponse> findCustomerByName(String name);
}
