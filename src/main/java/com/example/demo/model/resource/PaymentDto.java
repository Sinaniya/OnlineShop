package com.example.demo.model.resource;

import java.io.Serializable;

public class PaymentDto implements Serializable {

    private long id;
    private boolean done;
    private long OrderId;

    public PaymentDto (){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public long getOrderId() {
        return OrderId;
    }

    public void setOrderId(long orderId) {
        OrderId = orderId;
    }
}
