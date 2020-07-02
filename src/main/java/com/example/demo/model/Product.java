package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Table
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    private String name;
    private long count;




    //@OneToMany(mappedBy = "product", cascade= CascadeType.ALL, orphanRemoval = true)
   // private List<Basket> basket;

    @ManyToMany(fetch= FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();



    @ManyToMany(fetch= FetchType.LAZY)
    private List<Basket> baskets = new ArrayList<>();


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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }



}
