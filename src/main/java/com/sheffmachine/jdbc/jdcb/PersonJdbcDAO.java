package com.sheffmachine.jdbc.jdcb;

import com.sheffmachine.jdbc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // Let's do a SELECT * FROM PERSON
    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM PERSON", new BeanPropertyRowMapper<>(Person.class));
    }

    // Let's find a person by id
    public Person findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM PERSON WHERE ID = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)
        );
    }
}
