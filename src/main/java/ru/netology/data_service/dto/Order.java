package ru.netology.data_service.dto;

import java.time.LocalDate;

public class Order {
    private Long id;
    private LocalDate date;
    private Long customer_id;
    private String product_name;
    private Integer amount;

    public Order(String product_name) {
        this.product_name = product_name;
    }

    public Order(Long id, LocalDate date, Long customer_id, String product_name, Integer amount) {
        this.id = id;
        this.date = date;
        this.customer_id = customer_id;
        this.product_name = product_name;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
