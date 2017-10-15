package com.restful.entity;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "Users")
public class User implements Serializable {
	
	private static final long serialVersionUID = -7988799579036225137L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private int age;

    public User () {
    }
    
    public User (long id, int age, String name) {
    	this.id = id;
		this.age = age;
		this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}