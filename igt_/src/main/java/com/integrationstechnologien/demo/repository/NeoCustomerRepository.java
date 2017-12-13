package com.integrationstechnologien.demo.repository;

import com.integrationstechnologien.demo.domain.NeoCustomer;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.Date;
import java.util.List;

public interface NeoCustomerRepository extends GraphRepository<NeoCustomer> {
    NeoCustomer findByName(String name);
    List<NeoCustomer> findByDateBetween(Date from, Date to);
}
