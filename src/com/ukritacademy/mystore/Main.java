package com.ukritacademy.mystore;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Comics book", 10.5, 5);
        Product product2 = new Product("Magazine", 1.2, 3);
        Product product3 = new Product("Canon", 300.5, 5);
        Product product4 = new Product("Nikon", 150.5, 4);
        Product product5 = new Product("Scott", 730.5, 3);
        Product product6 = new Product("Cannondale", 900.5, 5);
        Product product7 = new Product("Swinn", 870.5, 4);

        Category cat1 = new Category("Cameras");
        Category cat2 = new Category("Books");
        Category cat3 = new Category("Bikes");

        cat1.addProduct(product3);
        cat1.addProduct(product4);


        cat2.addProduct(product1);
        cat2.addProduct(product2);


        cat3.addProduct(product5);
        cat3.addProduct(product6);
        cat3.addProduct(product7);

        User user = new User("userlogin", "userpassword");
        user.getShoppingCart().addProductToCart(product1);
        user.getShoppingCart().addProductToCart(product2);
        System.out.println(user.getShoppingCart().toString());
        user.getShoppingCart().printProductsInCart();
    }
}
