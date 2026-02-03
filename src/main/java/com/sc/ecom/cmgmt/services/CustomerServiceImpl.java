package com.sc.ecom.cmgmt.services;

import com.sc.ecom.cmgmt.dao.CustomerDao;
import com.sc.ecom.cmgmt.dao.entities.Customer;
import com.sc.ecom.cmgmt.requests.CustomerRequest;
import com.sc.ecom.cmgmt.responses.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public String createCustomer(CustomerRequest request) {
        System.out.println("Creating customer: " + request);
        Customer customer = convertRequestToEntity(request);
        String saveMessage = customerDao.saveCustomer(customer);
        if(saveMessage.equals("Customer saved successfully")) {
            System.out.println("Customer created successfully in service layer");
            return "Customer created successfully";
        } else {
            System.out.println("Failed to create customer in service layer");
            return "Customer creation failed";
        }
    }

    private Customer convertRequestToEntity(CustomerRequest request) {
        Customer customer = null;
        if(Objects.nonNull(request)){
            customer = new Customer();
            customer.setId(request.getCustId());
            customer.setName(request.getCustName());
            customer.setAddress(request.getCustAddr());
        }
        return customer;
    }

    @Override
    public String modifyCustomer(CustomerRequest request) {
        System.out.println("Modifying customer: " + request);
        Customer customer = convertRequestToEntity(request);
        String updateMessage = customerDao.updateCustomer(customer);
        if(updateMessage.equals("Customer updated successfully")) {
            System.out.println("Customer updated successfully in service layer");
            return "Customer updated successfully";
        } else {
            System.out.println("Failed to update customer in service layer");
            return "Customer update failed";
        }
    }

    @Override
    public CustomerResponse findCustomerById(Long id) {
        System.out.println("Finding customer by ID: " + id);
        Customer customer = customerDao.getCustomerById(id);
        CustomerResponse customerResponse = null;
        if(customer != null) {
            System.out.println("Customer found: " + customer);
            customerResponse = convertEntityToResponse(customer);
            return customerResponse;
        } else {
            System.out.println("Customer not found with ID: " + id);
            return null;
        }
    }

    private CustomerResponse convertEntityToResponse(Customer customer) {
        CustomerResponse customerResponse = null;
        if(Objects.nonNull(customer)){
            customerResponse = new CustomerResponse();
            customerResponse.setCustId(customer.getId());
            customerResponse.setCustName(customer.getName());
            customerResponse.setCustAddr(customer.getAddress());
        }
        return customerResponse;
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

    @Override
    public List<CustomerResponse> findAllCustomers() {
        List<Customer> customers = customerDao.getAllCustomers();
        List<CustomerResponse> customerResponses = convertEntityListToResponseList(customers);
        return customerResponses;
    }

    private List<CustomerResponse> convertEntityListToResponseList(List<Customer> customers) {
        List<CustomerResponse> customerResponseList = null;
        if(!CollectionUtils.isEmpty(customers)){
            customerResponseList = new ArrayList<>();
            /*for(int i = 0; i < customers.size(); i++){
                Customer customer = customers.get(i);
                CustomerResponse customerResponse = convertEntityToResponse(customer);
                customerResponseList.add(customerResponse);
            }*/

            /*for(Customer customer : customers){
               *//* CustomerResponse customerResponse = convertEntityToResponse(customer);
                customerResponseList.add(customerResponse);*//*
                customerResponseList.add(convertEntityToResponse(customer));
            }*/

            customerResponseList = customers.stream().map(customer -> convertEntityToResponse(customer))
                    .collect(Collectors.toList());
        }
        return  customerResponseList;
    }
}
