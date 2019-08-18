package com.sheffmachine.jdbc;

import com.sheffmachine.jdbc.entity.Person;
import com.sheffmachine.jdbc.jdcb.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJdbcDAO personJdbcDAO;

    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(
                "All users -> {}", personJdbcDAO.findAll()
        );

        logger.info(
                "User 10001 is {}", personJdbcDAO.findById(10001)
        );

        logger.info(
                "Deleting 10002 is {}", personJdbcDAO.deleteById(10002)
        );

        logger.info(
                "Inserting 10006 is {}", personJdbcDAO.insert(new Person(10006, "Finn", "Berlin", new Date()))
        );

        logger.info(
                "Updating 10006 is {}", personJdbcDAO.update(new Person(10006, "Josh", "Berlin", new Date()))
        );
    }
}
