package com.sheffmachine.jdbc;

import com.sheffmachine.jdbc.entity.Person;
import com.sheffmachine.jdbc.jpa.PersonJpaRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJpaRespository personJpaRespository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(
                "All users -> {}", personJpaRespository.findAll()
        );

        logger.info(
                "User 10001 is {}", personJpaRespository.findById(10001)
        );

        personJpaRespository.delete(10002);

//        logger.info(
//                "Deleting person", personJpaRespository.delete(10002)
//        );

        logger.info(
                "Inserting 10006 is {}", personJpaRespository.insert(new Person(10006, "Finn", "Berlin", new Date()))
        );

        logger.info(
                "Updating 10006 is {}", personJpaRespository.update(new Person(10006, "Josh", "Berlin", new Date()))
        );
    }
}
