package com.yanjd.girl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Girl {
    public Girl() {

    }
    public Girl(Integer id) {
        this.id = id;
    }
    public Girl(Integer id, Integer age, String name, String cupSize) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.cupSize = cupSize;
    }
    public Girl(Integer age, String name, String cupSize) {
        this.age = age;
        this.name = name;
        this.cupSize = cupSize;
    }


    @Id
    @GeneratedValue
    private Integer id;
    private Integer age;
    private String name;
    private String cupSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }
}
