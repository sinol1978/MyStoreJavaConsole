package com.ukritacademy.mystore;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ShoppingCart {
    private Product[] productsInCart;
    private LocalDateTime date;

    private ResourceBundle rb = ResourceBundle.getBundle("cart", new Locale("en", "EN"));
    //private ResourceBundle rb = ResourceBundle.getBundle("cart", new Locale ("ua", "UA"));

    public ShoppingCart() {
        this.productsInCart = new Product[0];
        date = LocalDateTime.now();
    }

    public Product[] getProductsInCart() {
        return productsInCart;
    }

    public LocalDateTime getDate() {
        return date;
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
        System.out.println(String.format("Product %s was added in your cart", productsInCart[productsInCart.length - 1]));
    }

    public void printProductsInCart() throws UnsupportedEncodingException {

        if (productsInCart.length > 0) {
            int i = 0;
            System.out.println(String.format("%-1s %-20s%10s%11s", rb.getString("number"), rb.getString("name"), rb.getString("price"), rb.getString("rating")));
            System.out.println("---------------------------------------------");
            for (Product item : productsInCart) {
                System.out.println(String.format("%-1s. %s", ++i, item));
            }
            System.out.println("---------------------------------------------");
        } else {
            System.out.println("Shopping cart is empty.");
        }
    }

    public void сlearCart() {
        this.setProductsInCart(new Product[0]);
    }

    @Override
    public String toString() {
        System.out.println(getDate().getDayOfMonth() + " - " + getDate().getMonth() + " - " + getDate().getYear());
        double total = 0.0;
        for (Product item : productsInCart) {
            total += item.getPrice();
        }
        try {
            printProductsInCart();
//            printProductsInCart(Locale.ROOT);
        } catch (UnsupportedEncodingException e) {

        }
        return String.format("%s: %s %s.\t%s: %7.2f$", rb.getString("scart"), this.productsInCart.length, rb.getString("pcs"), rb.getString("total"), total);

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
