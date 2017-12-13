package com.integrationstechnologien.demo.domain;

import com.integrationstechnologien.demo.DemoApplication;
import com.integrationstechnologien.demo.Profiles;
import com.integrationstechnologien.demo.repository.MongoCustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@ActiveProfiles(Profiles.MONGODB)
public class MongoCustomerTest {
    @Autowired
    private MongoCustomerRepository mongoCustomerRepository;

    @Test
    public void canSuccessfullySaveCustomer() throws Exception {
        MongoCustomer mongoCustomer = mongoCustomerRepository.save(new MongoCustomer(
                "mongoUser", "Rheinau", new Date()));

        assertThat(mongoCustomer).isNotNull();
        assertThat(mongoCustomer.getcId()).isNotNull();
    }


}