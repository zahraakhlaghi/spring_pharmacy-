package com.mkyong.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String username;
    private String password;
    private String address;
    private String email;
    private String phone;

    public User(Integer id, String name, String username, String password, String address, String email, String phone) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }


    public User(String name, String username, String password, String address, String email, String phone) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }


}
