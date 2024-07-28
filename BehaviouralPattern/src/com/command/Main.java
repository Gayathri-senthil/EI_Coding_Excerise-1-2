package com.command;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Enter command (on/off/undo/exit): ");
            input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "on":
                    remote.setCommand(lightOn);
                    remote.pressButton();
                    break;
                case "off":
                    remote.setCommand(lightOff);
                    remote.pressButton();
                    break;
                case "undo":
                    remote.pressUndo();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid command. Please enter 'on', 'off', 'undo', or 'exit'.");
            }
        }
    }
}
