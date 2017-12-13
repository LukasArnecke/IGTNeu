package com.integrationstechnologien.demo.service;

import com.integrationstechnologien.demo.domain.Customer;

public interface CustomerService {

    public Customer create(Customer customer);

    public Customer read(String id);

    public Customer update(String id, Customer customer);

    public void delete(String id);

    public void deleteAll();

}