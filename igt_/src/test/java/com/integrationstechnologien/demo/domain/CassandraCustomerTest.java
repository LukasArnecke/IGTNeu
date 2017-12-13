package com.integrationstechnologien.demo.domain;

import com.integrationstechnologien.demo.DemoApplication;
import com.integrationstechnologien.demo.Profiles;
import com.integrationstechnologien.demo.repository.CassandraCustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@ActiveProfiles(Profiles.CASSANDRA)
public class CassandraCustomerTest {
    @Autowired
    CassandraCustomerRepository cassandraCustomerRepository;

    @Test
    @Transactional
    public void canSuccessfullySaveCustomer() throws Exception {
        CassandraCustomer cassandraCustomer = cassandraCustomerRepository.save(new CassandraCustomer(
                "cassandraCustomer", "Rheinau", new Date()));

        assertThat(cassandraCustomer).isNotNull();
        assertThat(cassandraCustomer.getcId()).isNotNull();

}}