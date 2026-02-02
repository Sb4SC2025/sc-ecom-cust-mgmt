package com.sc.ecom.cmgmt.services;

import com.sc.ecom.cmgmt.requests.CustomerRequest;

public interface CustomerService {
    public String createCustomer(CustomerRequest request);
    public String modifyCustomer(CustomerRequest request);
    public CustomerRequest findCustomerById(Long id);
    public String removeCustomerById(Long id);

}
