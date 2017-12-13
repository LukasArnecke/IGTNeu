package com.integrationstechnologien.demo.service;

import com.integrationstechnologien.demo.domain.Customer;
import com.integrationstechnologien.demo.domain.NeoCustomer;
import com.integrationstechnologien.demo.domain.NeoOrder;
import com.integrationstechnologien.demo.repository.NeoCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Neo4jCustomerService implements CustomerService {

    @Autowired
    NeoCustomerRepository neoCustomerRepository;

    //@Autowired
    //NeoOrderRepository neoOrderRepository;

    @Override
    public Customer create(Customer customer) {
        NeoCustomer neoCustomer = new NeoCustomer(customer);
        neoCustomerRepository.save(neoCustomer);
        return customer;
    }

    @Override
    public Customer read(String id) { return neoCustomerRepository.findOne(Long.valueOf(id)); }

    @Override
    public Customer update(String id, Customer customer) {
        NeoCustomer neoCustomer = neoCustomerRepository.findOne(Long.valueOf(id));
        neoCustomer.copy(customer);
        neoCustomerRepository.save(neoCustomer);
        return customer;
    }

    @Override
    public void delete(String id) {
        neoCustomerRepository.delete(Long.valueOf(id));
    }

    @Override
    public void deleteAll() { neoCustomerRepository.deleteAll(); }
}
