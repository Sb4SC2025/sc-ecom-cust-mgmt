package com.sc.ecom.cmgmt.dao;

import com.sc.ecom.cmgmt.requests.CustomerRequest;
import com.sc.ecom.cmgmt.services.CustomerService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDao {

    List<CustomerRequest> customerDB = new ArrayList<>();

    public String saveCustomer(CustomerRequest customer) {
        System.out.println("Saving customer to the database: " + customer);
        customerDB.add(customer);
        return "Customer saved successfully";
    }


    public List<CustomerRequest> getAllCustomers() {
        return customerDB;
    }

    public String updateCustomer(CustomerRequest customer) {
        System.out.println("Updating customer in the database: " + customer);
        for (int i = 0; i < customerDB.size(); i++) {
            if (customerDB.get(i).getCustId().equals(customer.getCustId())) {
                customerDB.set(i, customer);
                return "Customer updated successfully";
            }
        }
        return "Customer not found";
    }

    public CustomerRequest getCustomerById(Long custId) {
        for (CustomerRequest customer : customerDB) {
            if (customer.getCustId().equals(custId)) {
                return customer;
            }
        }
        return null;
    }
}
