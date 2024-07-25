package com.zharnikova.example.dto;

import java.util.Objects;

public class CustomerDto {
    private int id;
    private String name;
    private String phone;
    private String email;

    public CustomerDto() {
    }

    public CustomerDto(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public CustomerDto(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CustomerDto that = (CustomerDto) object;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(phone, that.phone) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, email);
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
