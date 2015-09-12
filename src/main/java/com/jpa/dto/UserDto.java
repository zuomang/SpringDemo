package com.jpa.dto;

/**
 * Created by Mang on 15/9/12.
 */
public class UserDto {
    private String name;

    public UserDto(String name) {
        this.name = name;
    }

    public UserDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
