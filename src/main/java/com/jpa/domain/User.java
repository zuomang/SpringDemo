package com.jpa.domain;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mang on 9/10/15.
 */
@Entity
@Table(
        name = "T_USERS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"USERNAME", "EMAIL"})
)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "idGenerator", strategy = "identity")
    @GeneratedValue(generator = "idGenerator")
    private Integer id;

    @Column(name = "USERNAME")
    @NotNull
    private String name;

    @Column(name = "EMAIL")
    @NotNull
    private String email;

    @Column(name = "PASSWORD")
    @NotNull
    private String password;

    @Column(name = "CREATE_TIME")
    @NotNull
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    @NotNull
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

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
