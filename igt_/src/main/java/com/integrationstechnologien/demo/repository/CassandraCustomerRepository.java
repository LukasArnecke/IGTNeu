package com.integrationstechnologien.demo.repository;

import com.integrationstechnologien.demo.domain.CassandraCustomer;
import com.integrationstechnologien.demo.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CassandraCustomerRepository extends CrudRepository<CassandraCustomer, UUID> {

}
