package com.jpa.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mang on 9/10/15.
 */
@Entity
@Table(name = "T_USER")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "idGenerator", strategy = "identity")
    @GeneratedValue(generator = "idGenerator")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "name: " + name + " email: " + email + " password: " + password;
    }
}
