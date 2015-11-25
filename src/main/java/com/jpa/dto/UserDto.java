package com.jpa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Mang on 15/9/12.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private int id;
    private String name;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
