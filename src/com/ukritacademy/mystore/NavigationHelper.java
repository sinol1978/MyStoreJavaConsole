package com.ukritacademy.mystore;

import java.util.Comparator;
import java.util.Scanner;

public class NavigationHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static User getAuth() {
        String login, password;
        System.out.println("Please enter your login: ");
        login = scanner.nextLine();
        System.out.println("Please enter your password: ");
        password = scanner.nextLine();
        if(verify(login, password)) {
            return new User(login, password);
        }
        return new User();
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
        return (Product) categories[catIndex].getProducts().get(prodIndex);
    }

    public static int getIndex() {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return 0;
    }

    public static void printProductsInCategory(Category category) {
        Comparator<Product> productComparator = Comparator.comparing(Product::getPrice);
        category.getProducts().sort(productComparator);
        category.getProducts().forEach(System.out::println);
    }

    public static Scanner getScanner() {
        return scanner;
    }

    private static boolean verify(String login, String password){
        try {
            if (login.length() > 20) {
                throw new LoginException("Login length is more than 20 chars");
            }
            if (password.length() > 20) {
                throw new PasswordException("Password error");
            }
        } catch (LoginException | PasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
