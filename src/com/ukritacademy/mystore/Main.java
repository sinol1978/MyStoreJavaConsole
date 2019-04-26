package com.ukritacademy.mystore;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product(0, "Comics book", 10.5, 5);
        Product product2 = new Product(1, "Magazine", 1.2, 3);
        Product product3 = new Product(2, "Canon", 300.5, 5);
        Product product4 = new Product(3, "Nikon", 150.5, 4);
        Product product5 = new Product(4, "Scott", 730.5, 3);
        Product product6 = new Product(5, "Cannondale", 900.5, 5);
        Product product7 = new Product(6, "Shwinn", 870.5, 4);

        Category cat1 = new Category(0,"Cameras");
        Category cat2 = new Category(1,"Books");
        Category cat3 = new Category(2,"Bikes");
        Category[] categories = {cat1, cat2, cat3};

        cat1.addProduct(product3);
        cat1.addProduct(product4);
        cat2.addProduct(product1);
        cat2.addProduct(product2);
        cat3.addProduct(product5);
        cat3.addProduct(product6);
        cat3.addProduct(product7);

        //User user = new User();
        Map<Integer, User> users = new HashMap<>();
        User user1 = new User(1, "nickname1", "password1");
        User user2 = new User(2, "nickname2", "password2");
        User user3 = new User(3, "nickname3", "password3");
        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);
        users.put(user3.getId(), user3);
        User user = new User();
        while (true) {
            System.out.println("1. Log In\t2. Categories\t3. Add To Cart\t4. Confirm Order\t5. Exit");
            Scanner scanner = new Scanner(System.in);
            Action action = Action.values()[Integer.parseInt(scanner.nextLine()) - 1];
            switch (action) {
                case REGISTRATION:
                    User tempUser1 = NavigationHelper.getAuth();
                    System.out.println("Registration:");
                    if(users.containsKey(tempUser1.getId()) && users.containsValue(tempUser1)){
                        System.out.println("This user already exists!");
                    }
                    else{
                        users.put(tempUser1.getId(), tempUser1);
                        System.out.println("Registration completed.");
                    }
                    break;
                case LOGIN:
                    System.out.println("Log in:");
                    User tempUser2 = NavigationHelper.getAuth();
                    if(users.containsKey(tempUser2.getId()) && users.containsValue(tempUser2)){
                        System.out.printf("Welcome, %s!\n", tempUser2.getLogin());
                        user = tempUser2;
                    }
                    else{
                        System.out.println("This user doesn't exist!");
                        System.out.println("Please compete the registration.");
                    }
                    break;
                case CAT_LIST:
                    NavigationHelper.printCategories(categories);
                    break;
                case ADD_TO_CART:
                    Product product = NavigationHelper.selectProduct(categories);
                    user.getShoppingCart().addProductToCart(product);
                    break;
                case CONFIRM_ORDER:
                    System.out.println(user.getShoppingCart());
                    user.getShoppingCart().сlearCart();
                    break;
                case EXIT:
                    System.exit(0);
            }
        }
    }
}
