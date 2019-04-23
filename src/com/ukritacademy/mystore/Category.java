package com.ukritacademy.mystore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Category {
    private int id;
    private String name;
    private List<Product> products;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        this.products = new ArrayList<>();
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

    public List getProducts() {
        return products;
    }

    public boolean addProduct(Product product) {
        try {
            product.setCategoryId(this.id);
            this.products.add(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeProduct(Product product) {
        try {
            this.products.remove(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("Category: %10s\t\tProducts%3s", this.getName(), this.products.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(products, category.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, products);
    }
}