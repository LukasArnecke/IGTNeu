package com.integrationstechnologien.demo.domain;

import com.integrationstechnologien.demo.DemoApplication;
import com.integrationstechnologien.demo.Profiles;
import com.integrationstechnologien.demo.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@ActiveProfiles(Profiles.MYSQL)
public class MyCustomerTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    @Transactional
    public void canSuccessfullySaveCustomer() throws Exception {
        MyCustomer myCustomer = repository.save(new MyCustomer(
                "testCustomer", "Rheinau", new Date()));

        assertThat(myCustomer).isNotNull();
        assertThat(myCustomer.getcId()).isNotNull();


        //MyCustomer testCustomer = ;


        //MyCustomer testCustomer2 = new MyCustomer("TestTest", "Neckarau",new Date());

        //EntityManager entityManager = entityManagerFactory.createEntityManager();
        //EntityTransaction transaction = entityManager.getTransaction();
        //transaction.begin();
        //EntityTransaction transaction2 = entityManager.getTransaction();
        //zweite Transaktion geht nicht
        //transaction2.begin();
        //entityManager.persist(testCustomer);
        //entityManager.persist(testCustomer2);
        //transaction.commit();
        //transaction2.commit();
        //entityManager.close();
    }
}
