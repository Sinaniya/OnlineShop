package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Payment implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;

    private boolean done;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;



    public Payment() {
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
