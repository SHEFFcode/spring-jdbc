package com.sheffmachine.jdbc;

import com.sheffmachine.jdbc.jdcb.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
    }
}
