package com.ukritacademy.mystore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Category {

    private String name;
    private Product[] products;

    public Category(String name) {
        this.name = name;
        products = new Product[0];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public void addProduct(Product product){
        Product[] temp = new Product[this.products.length + 1];
        int i = 0;
        for (Product item : this.products){
            temp[i++] = item;
        }
        temp[this.products.length] = product;
        products = temp;
    }

    public void printProductsInCategory(){
        int i = 0;
        for(Product item : products) {
            System.out.println("\t" + (++i) + ". " + item.toString());
        }
    }

    @Override
    public String toString() {
        return "Category: " + this.getName() + "\t\tProducts: " + this.products.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Arrays.equals(products, category.products);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(products);
        return result;
    }
}
