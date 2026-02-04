package com.sc.ecom.cmgmt.dao;



import com.sc.ecom.cmgmt.dao.entities.Customer;

import java.util.List;

public interface CustomerDao {

    public String saveCustomer(Customer customer);
    public List<Customer> getAllCustomers();
    public String updateCustomer(Customer customer);
    public Customer getCustomerById(Long custId);
    public String removeCustomerById(Long id);

    public List<Customer> findCustomerByAddress(String addr);
    public List<Customer> findCustomerByName(String name);
}
