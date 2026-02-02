package com.sc.ecom.cmgmt.dao;

import com.sc.ecom.cmgmt.requests.CustomerRequest;

import java.util.List;

public interface CustomerDao {

    public String saveCustomer(CustomerRequest customer);
    public List<CustomerRequest> getAllCustomers();
    public String updateCustomer(CustomerRequest customer);
    public CustomerRequest getCustomerById(Long custId);
    public String removeCustomerById(Long id);
}
