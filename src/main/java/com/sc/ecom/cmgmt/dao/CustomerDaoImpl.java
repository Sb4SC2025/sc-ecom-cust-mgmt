package com.sc.ecom.cmgmt.dao;

import com.sc.ecom.cmgmt.requests.CustomerRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao{

    List<CustomerRequest> customerDB = new ArrayList<>();

    @Override
    public String saveCustomer(CustomerRequest customer) {
        System.out.println("Saving customer to the database: " + customer);
        customerDB.add(customer);
        return "Customer saved successfully";
    }


    @Override
    public List<CustomerRequest> getAllCustomers() {
        return customerDB;
    }

    @Override
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

    @Override
    public CustomerRequest getCustomerById(Long custId) {
        for (CustomerRequest customer : customerDB) {
            if (customer.getCustId().equals(custId)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public String removeCustomerById(Long id) {
        System.out.println("Updating customer in the database: " + id);
        for (int i = 0; i < customerDB.size(); i++) {
            if (customerDB.get(i).getCustId().equals(id)) {
                customerDB.remove(i);
                return "Customer deleted successfully";
            }
        }
        return "Customer not found";
    }
}
