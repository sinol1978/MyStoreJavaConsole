package com.ukritacademy.mystore;

import java.util.Scanner;

public class NavigationHelper {

    public static User getAuth() {
        Scanner sc = new Scanner(System.in);
        String login, password;
        System.out.println("Login: ");
        login = sc.nextLine();
        System.out.println("Password: ");
        password = sc.nextLine();
        User user = new User(login, password);
        return user;
    }

    public static void getCategories(Category[] categories) {
        for (Category item : categories) {
            System.out.println(item.toString());
        }
    }

    public static void getProducts(Category category) {
        category.printProductsInCategory();
    }
}
