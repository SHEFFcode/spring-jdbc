package com.sheffmachine.jdbc.jdcb;

import com.sheffmachine.jdbc.entity.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setName(resultSet.getString("location"));
        person.setBirth_date(resultSet.getTimestamp("birth_date"));

        return person;
    }
}
