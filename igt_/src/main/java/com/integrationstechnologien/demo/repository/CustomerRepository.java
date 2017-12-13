package com.integrationstechnologien.demo.repository;
import com.integrationstechnologien.demo.domain.MyCustomer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<MyCustomer, Long> {

}
