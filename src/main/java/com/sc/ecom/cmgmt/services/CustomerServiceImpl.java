package com.sc.ecom.cmgmt.services;

import com.sc.ecom.cmgmt.dao.CustomerDao;
import com.sc.ecom.cmgmt.requests.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public String createCustomer(CustomerRequest request) {
        System.out.println("Creating customer: " + request);
        String saveMessage = customerDao.saveCustomer(request);
        if(saveMessage.equals("Customer saved successfully")) {
            System.out.println("Customer created successfully in service layer");
            return "Customer created successfully";
        } else {
            System.out.println("Failed to create customer in service layer");
            return "Customer creation failed";
        }
    }

    @Override
    public String modifyCustomer(CustomerRequest request) {
        System.out.println("Modifying customer: " + request);
        String updateMessage = customerDao.updateCustomer(request);
        if(updateMessage.equals("Customer updated successfully")) {
            System.out.println("Customer updated successfully in service layer");
            return "Customer updated successfully";
        } else {
            System.out.println("Failed to update customer in service layer");
            return "Customer update failed";
        }
    }

    @Override
    public CustomerRequest findCustomerById(Long id) {
        System.out.println("Finding customer by ID: " + id);
        CustomerRequest customer = customerDao.getCustomerById(id);
        if(customer != null) {
            System.out.println("Customer found: " + customer);
            return customer;
        } else {
            System.out.println("Customer not found with ID: " + id);
            return null;
        }
    }

    @Override
    public String removeCustomerById(Long id) {
        System.out.println("Modifying customer: " + id);
        String deleteMessage = customerDao.removeCustomerById(id);
        if(deleteMessage.equals("Customer deleted successfully")) {
            System.out.println("Customer deleted successfully in service layer");
            return "Customer deleted successfully";
        } else {
            System.out.println("Failed to delete customer in service layer");
            return "Customer delete failed";
        }
    }
}
