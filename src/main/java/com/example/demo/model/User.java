package com.example.demo.model;


import javax.persistence.*;
import java.util.List;
import java.io.Serializable;

@Table
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String userName;
    // @

    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Basket> baskets;

    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    public User() {
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

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    public List<Order> getOrder() {
        return orders;
    }

    public void setOrder(List<Order> order) {
        this.orders = order;
    }

    public void addOrder(Order order){
        order.setUser(this);
        this.orders.add(order);
    }
public void removeOrder(Order order){
        this.orders.remove(order);
        order.setUser(null); //+ add + remove basket

}


}
