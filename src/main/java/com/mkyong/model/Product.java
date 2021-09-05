package com.mkyong.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String description;
    private String image;
    private Integer price;
    private Integer number;
    private String company;


    public Product(Integer id, String name, String description, String image, Integer price, Integer number, String company) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.number = number;
        this.company = company;
    }

    public Product(String name, String description, String image, Integer price, Integer number, String company) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.number = number;
        this.company = company;
    }
}
