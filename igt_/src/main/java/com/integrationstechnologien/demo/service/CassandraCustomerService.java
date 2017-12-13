package com.integrationstechnologien.demo.service;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import com.integrationstechnologien.demo.domain.CassandraCustomer;
import com.integrationstechnologien.demo.domain.Customer;
import com.integrationstechnologien.demo.repository.CassandraCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
@Profile("Cassandra")
public class CassandraCustomerService implements CustomerService {

    @Autowired
    CassandraCustomerRepository cassandraCustomerRepository;

    @Override
    public Customer create(Customer customerData){
        CassandraCustomer cassandraCustomer = new CassandraCustomer(customerData);
        cassandraCustomerRepository.save(cassandraCustomer);
        return cassandraCustomer;
    }

    @Override
    public Customer read(String id) {
        return cassandraCustomerRepository.findOne(UUID.fromString(id));
    }


    @Override
    public Customer update(String id, Customer customerData) {
        CassandraCustomer customer = cassandraCustomerRepository.findOne(UUID.fromString(id));
        customer.copy(customerData);
        cassandraCustomerRepository.save(customer);
        return customer;
    }

    @Override
    public void delete(String id) {
        cassandraCustomerRepository.delete(UUID.fromString(id));
    }

    @Override
    public void deleteAll() {
        cassandraCustomerRepository.deleteAll();
    }

}
