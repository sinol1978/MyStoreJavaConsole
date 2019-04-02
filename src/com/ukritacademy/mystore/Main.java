package com.ukritacademy.mystore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     
        Product product1 = new Product("Comics book", 10.5, 5);
        Product product2 = new Product("Magazine", 1.2, 3);
        Product product3 = new Product("Canon", 300.5, 5);
        Product product4 = new Product("Nikon", 150.5, 4);
        Product product5 = new Product("Scott", 730.5, 3);
        Product product6 = new Product("Cannondale", 900.5, 5);
        Product product7 = new Product("Shwinn", 870.5, 4);

        Category cat1 = new Category("Cameras");
        Category cat2 = new Category("Books");
        Category cat3 = new Category("Bikes");
        Category[] categories = {cat1, cat2, cat3};

        cat1.addProduct(product3);
        cat1.addProduct(product4);
        cat2.addProduct(product1);
        cat2.addProduct(product2);
        cat3.addProduct(product5);
        cat3.addProduct(product6);
        cat3.addProduct(product7);

        User user = new User();
        while(true) {
            System.out.println("1. Log In\t2. Categories\t3. Add To Cart\t4. Confirm Order\t5. Exit");

            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            Action action = Action.values()[Integer.parseInt(choice) - 1];
            switch (action) {
                case LOGIN:
                    user = NavigationHelper.getAuth();
                    break;
                case CAT_LIST:
                    NavigationHelper.printCategories(categories);
                    break;
                case ADD_TO_CART:
                    Product product = NavigationHelper.selectProduct(categories);
                    user.getShoppingCart().addProductToCart(product);
                    break;
                case CONFIRM_ORDER:
                    System.out.println(user.getShoppingCart().toString());
                    user.getShoppingCart().сlearCart();
                    break;
                case EXIT:
                    System.exit(0);
            }
        }
    }
}
