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
        }
    }

    public static Product selectProductInCategories(Category[] categories) {
        System.out.println("Select category: ");
        int indexCat = getIndex();
        if (indexCat > 0 && indexCat <= categories.length) {
            printProductsInCategory(categories[indexCat - 1]);
        } else {
            System.out.println("Wrong category number!");
        }
        System.out.println("Select product: ");
        int indexProduct = getIndex();

        return categories[indexCat - 1].getProducts()[indexProduct-1];
    }

    public static int getIndex() {
        scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return 0;
    }


    public static void printProductsInCategory(Category category) {
        System.out.println(category);
        int i = 1;
        for (Product item : category.getProducts()) {
            System.out.println(String.format("%s. %s", i++, item));
        }
    }

    public static void getAllProducts(Category[] categories) {
        for (Category item : categories) {
            System.out.println(item);
            item.printProductsInCategory();
        }
    }

    public static Scanner getScanner() {
        return scanner;
    }
}
