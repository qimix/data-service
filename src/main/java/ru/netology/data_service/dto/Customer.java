package ru.netology.data_service.dto;

import java.math.BigInteger;

public class Customer {
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private BigInteger phone_number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigInteger getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(BigInteger phone_number) {
        this.phone_number = phone_number;
    }
}
