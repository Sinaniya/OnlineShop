package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;


@Entity
@Table
public class Basket implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany(mappedBy = "baskets" , cascade= CascadeType.ALL)
    private List<Product> products;


    public Basket() {
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }





    public void addProduct(Product product){
        product.getBaskets().add(this);//+
        this.products.add(product);

    }

    public void removeProduct(Product product){
        this.products.remove(product);
        product.getBaskets().remove(this);
    }


}
