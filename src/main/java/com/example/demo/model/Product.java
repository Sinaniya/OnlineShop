package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Table
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private String name;




    //@OneToMany(mappedBy = "product", cascade= CascadeType.ALL, orphanRemoval = true)
   // private List<Basket> basket;

    @ManyToMany(fetch= FetchType.LAZY)
    private List<Order> orders;


    @ManyToMany(fetch= FetchType.LAZY)
    //@JoinColumn (name="basket_id")
    private List<Basket> baskets;


    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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
