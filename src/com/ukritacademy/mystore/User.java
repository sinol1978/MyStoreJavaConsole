package com.ukritacademy.mystore;

import java.util.Objects;

public class User {
    private String login;
    private String password;
    private ShoppingCart shoppingCart;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.shoppingCart = new ShoppingCart();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", shoppingCart=" + shoppingCart +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(shoppingCart, user.shoppingCart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, shoppingCart);
    }
}

