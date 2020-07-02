package com.example.demo.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    private String userName;
    private String password;
    // @

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true) //do we need this?
    private Basket basket = new Basket(); // is this correct?

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

    public User() {
        this.basket.setUser(this);
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    } // injaro Long kardam chon order.setId(null) error midad

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> order) {
        this.orders = order;
    }

    public void addOrder(Order order) {
        order.setUser(this);
        this.orders.add(order);
    }

    public void removeOrder(Order order) {
        this.orders.remove(order);
        order.setUser(null); //+ add + remove basket

    }


    public void removeBasket(Basket basket) {
        //this.orders.remove(basket);
        basket.setUser(null); //+ add + remove basket
    }

//    public void addBasket(Basket basket) {
//        basket.setUser(this);
//        //this.basket.add(basket);
//    }


}
