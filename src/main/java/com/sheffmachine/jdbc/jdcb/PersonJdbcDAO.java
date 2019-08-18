package com.sheffmachine.jdbc.jdcb;

import com.sheffmachine.jdbc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
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
                new PersonRowMapper()
        );
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM PERSON WHERE ID = ?", new Object[]{id});
    }

    public int insert(Person person) {
        return jdbcTemplate.update("INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES (?, ?, ?, ?)",
                person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirth_date().getTime()));
    }

    public int update(Person person) {
        return jdbcTemplate.update("UPDATE PERSON SET  NAME = ?, LOCATION = ?, BIRTH_DATE = ? WHERE ID = ?",
                person.getName(), person.getLocation(), new Timestamp(person.getBirth_date().getTime()), person.getId());
    }
}
