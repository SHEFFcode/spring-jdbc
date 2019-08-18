package com.sheffmachine.jdbc.jpa;

import com.sheffmachine.jdbc.entity.Person;
import com.sheffmachine.jdbc.jdcb.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonJpaRespository {
    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public void delete(int id) {
        Person personFromDb = findById(id);
        entityManager.remove(personFromDb);
    }

}
