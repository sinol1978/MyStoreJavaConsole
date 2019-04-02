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

    public static void printCategories(Category[] categories) {
        int i = 1;
        for (Category item : categories) {
            System.out.println(i++ + ". " + item);
            printProductsInCategory(item);
        }
    }

    public static Product selectProduct(Category[] categories) {
        System.out.println("Enter category number:");
        int catIndex = getIndex() - 1;
        System.out.println("Enter product number:");
        int prodIndex = getIndex() - 1;
        return categories[catIndex].getProducts()[prodIndex];
    }

    public static int getIndex() {
        scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return 0;
    }

    public static void printProductsInCategory(Category category) {
        int i = 1;
        for (Product item : category.getProducts()) {
            System.out.println(String.format("\t%s. %s", i++, item));
        }
    }
}
