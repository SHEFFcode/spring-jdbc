package com.sheffmachine.jdbc.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;
    private String location;
    private Date birth_date;

    public Person() {
    }

    @Override
    public String toString() {
        return "\n Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", locaiton='" + location + '\'' +
                ", birthdate=" + birth_date +
                '}';
    }

    public Person(int id, String name, String location, Date birth_date) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birth_date = birth_date;
    }


    public Person(String name, String location, Date birth_date) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birth_date = birth_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }
}
