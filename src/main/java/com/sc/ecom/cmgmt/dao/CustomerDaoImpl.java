package com.sc.ecom.cmgmt.dao;

import com.sc.ecom.cmgmt.dao.entities.Customer;
import com.sc.ecom.cmgmt.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class CustomerDaoImpl implements CustomerDao{

    //List<CustomerRequest> customerDB = new ArrayList<>();

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String saveCustomer(Customer customer) {
        System.out.println("Saving customer to the database: " + customer);
       // customerDB.add(customer);
        customerRepository.save(customer);
        return "Customer saved successfully";
    }


    @Override
    public List<Customer> getAllCustomers() {
       // return customerDB;
        return customerRepository.findAll();
    }

    @Override
    public String updateCustomer(Customer customer) {
        System.out.println("Updating customer in the database: " + customer);
       /* for (int i = 0; i < customerDB.size(); i++) {
            if (customerDB.get(i).getCustId().equals(customer.getCustId())) {
                customerDB.set(i, customer);
                return "Customer updated successfully";
            }
        }*/
        Customer dbCustomer = customerRepository.findById(customer.getId()).orElse(null);
        if(Objects.nonNull(dbCustomer)){
            dbCustomer.setName(customer.getName());
            dbCustomer.setAddress(customer.getAddress());
            customerRepository.save(dbCustomer);
        }
        return "Customer not found";
    }

    @Override
    public Customer getCustomerById(Long custId) {
        /*for (CustomerRequest customer : customerDB) {
            if (customer.getCustId().equals(custId)) {
                return customer;
            }
        }*/
        return customerRepository.findById(custId).orElse(null);
    }

    @Override
    public String removeCustomerById(Long id) {
        System.out.println("Updating customer in the database: " + id);
        /*for (int i = 0; i < customerDB.size(); i++) {
            if (customerDB.get(i).getCustId().equals(id)) {
                customerDB.remove(i);
                return "Customer deleted successfully";
            }
        }*/
        Customer dbCustomer = customerRepository.findById(id).orElse(null);
        if(Objects.nonNull(dbCustomer)){
           // customerRepository.deleteById(id);
            customerRepository.delete(dbCustomer);
        }
        return "Customer not found";
    }
}
