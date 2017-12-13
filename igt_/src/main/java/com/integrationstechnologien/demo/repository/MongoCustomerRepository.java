package com.integrationstechnologien.demo.repository;

import com.integrationstechnologien.demo.domain.MongoCustomer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface MongoCustomerRepository extends MongoRepository<MongoCustomer, String> {
    public List<MongoCustomer> findByDateBetween(Date from, Date till);
}
