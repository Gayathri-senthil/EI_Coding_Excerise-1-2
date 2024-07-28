package com.adapter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Media Player ---");
            System.out.println("1. Play Media");
            System.out.println("2. Display Supported Media Types");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Enter the type of media to play (mp3, mp4, vlc, avi, mkv): ");
                    String audioType = scanner.nextLine();
                    System.out.println("Enter the file name: ");
                    String fileName = scanner.nextLine();
                    audioPlayer.play(audioType, fileName);
                    break;
                case "2":
                    audioPlayer.displaySupportedTypes();
                    break;
                case "3":
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
