package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table
@Entity

public class Order implements Serializable {

 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;


    @ManyToMany(mappedBy = "orders", cascade = CascadeType.ALL)
     private List<Product> products;

    @OneToMany(mappedBy = "project", cascade= CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn (name="user_id")
    private User user;



    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public void addProduct(Product product){

        product.getOrders().add(this);
        this.products.add(product);
    }


    public void removeProduct(Product product) {
        this.products.remove(product);
       product.getOrders().remove(this);
    }

    public void addPayment(Payment paymnet){

        paymnet.setOrder(this);
        this.payments.add(paymnet);
    }
    public void removePaymnet(Payment payment){

        this.payments.remove(payment);
        payment.setOrder(null);
    }


}
