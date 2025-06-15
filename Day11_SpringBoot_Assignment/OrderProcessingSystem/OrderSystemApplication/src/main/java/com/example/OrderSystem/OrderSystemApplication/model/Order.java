package com.example.OrderSystem.OrderSystemApplication.model;


public class Order {
    private Long id;
    private OrderState state;
    private String description;

    public Order(Long id, String description) {
        this.id = id;
        this.description = description;
        this.state = OrderState.NEW;
    }

    public Long getId() { return id; }
    public OrderState getState() { return state; }
    public void setState(OrderState state) { this.state = state; }
    public String getDescription() { return description; }
}
