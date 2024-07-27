package com.zharnikova.example.model;

import java.util.Objects;

public class CustomersProducts {
    private String customer_name;
    private String product_name;

    public CustomersProducts() {
    }

    public CustomersProducts(String customer_name, String product_name) {
        this.customer_name = customer_name;
        this.product_name = product_name;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CustomersProducts that = (CustomersProducts) object;
        return Objects.equals(customer_name, that.customer_name) && Objects.equals(product_name, that.product_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer_name, product_name);
    }

    @Override
    public String toString() {
        return "CustomersProducts{" +
                "customer_name='" + customer_name + '\'' +
                ", product_name='" + product_name + '\'' +
                '}';
    }

}
