package com.strategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the amount to pay:");
        int amount = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Select payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.println("3. Cryptocurrency");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                cart.setPaymentStrategy(new CreditCardPayment());
                break;
            case 2:
                cart.setPaymentStrategy(new PayPalPayment());
                break;
            case 3:
                cart.setPaymentStrategy(new CryptoPayment());
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Credit Card.");
                cart.setPaymentStrategy(new CreditCardPayment());
        }

        cart.checkout(amount);
        scanner.close();
    }
}
