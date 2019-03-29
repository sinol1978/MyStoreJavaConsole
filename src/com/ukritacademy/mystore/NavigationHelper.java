package com.ukritacademy.mystore;

import java.util.Scanner;

public class NavigationHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static User getAuth() {
        String login, password;
        System.out.println("Login: ");
        login = scanner.nextLine();
        System.out.println("Password: ");
        password = scanner.nextLine();
        return new User(login, password);
    }

    public static void getCategories(Category[] categories) {
        for (Category item : categories) {
            System.out.println(item.toString());
        }
    }

    public static void getProducts(Category category) {
        category.printProductsInCategory();
    }

    public static Scanner getScanner() {
        return scanner;
    }
}
