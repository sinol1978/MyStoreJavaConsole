package com.ukritacademy.mystore;

import java.util.Arrays;

public class ShoppingCart {
    private Product[] productsInCart;

    public ShoppingCart() {
        this.productsInCart = new Product[0];
    }

    public Product[] getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(Product[] productsInCart) {
        this.productsInCart = productsInCart;
    }

    public void addProductToCart(Product product) {
        Product[] temp = new Product[this.productsInCart.length + 1];
        int i = 0;
        for (Product item : this.productsInCart) {
            temp[i++] = item;
        }
        temp[this.productsInCart.length] = product;
        productsInCart = temp;
    }

    public void printProductsInCart() {
        if (productsInCart.length > 0) {
            int i = 0;
            for (Product item : productsInCart) {
                System.out.println("\t" + (++i) + ". " + item.toString());
            }
        } else {
            System.out.println("Shopping cart is empty.");
        }
    }

    public void сlearCart() {
        this.setProductsInCart(new Product[0]);
    }

    @Override
    public String toString() {
        double total = 0.0;
        for (Product item : productsInCart) {
            total += item.getPrice();
        }
        return "Shopping Cart:\t" + this.productsInCart.length + " pcs.\tTotal: " + total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Arrays.equals(productsInCart, that.productsInCart);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(productsInCart);
    }
}
