package com.schedulemanager;

import com.schedulemanager.factory.TaskFactory;
import com.schedulemanager.model.Task;
import com.schedulemanager.singleton.ScheduleManager;
import com.schedulemanager.observer.ConflictObserver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        scheduleManager.addObserver(new ConflictObserver());
        Scanner scanner = new Scanner(System.in);
        int command;

        System.out.println("Welcome to the Astronaut Schedule Manager!");
        do {
            System.out.println("\nEnter a command \n");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Edit Task");
            System.out.println("5. Complete Task");
            System.out.println("6. View Tasks by Priority");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            command = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (command) {
                case 1:
                    addTask(scanner, scheduleManager);
                    break;
                case 2:
                    removeTask(scanner, scheduleManager);
                    break;
                case 3:
                    viewTasks(scanner, scheduleManager);
                    break;
                case 4:
                    editTask(scanner, scheduleManager);
                    break;
                case 5:
                    completeTask(scanner, scheduleManager);
                    break;
                case 6:
                    viewTasksByPriority(scanner, scheduleManager);
                    break;
                case 7:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        } while (command != 7);

        scanner.close();
    }

    private static void addTask(Scanner scanner, ScheduleManager scheduleManager) {
        System.out.println("Enter task description:");
        String description = scanner.nextLine();
        System.out.println("Enter task start time (HH:mm):");
        String startTime = scanner.nextLine();
        System.out.println("Enter task end time (HH:mm):");
        String endTime = scanner.nextLine();
        System.out.println("Enter task priority (High, Medium, Low):");
        String priority = scanner.nextLine();

        Task task = TaskFactory.createTask(description, startTime, endTime, priority);
        scheduleManager.addTask(task);
    }

    private static void removeTask(Scanner scanner, ScheduleManager scheduleManager) {
        System.out.println("Enter task description to remove:");
        String description = scanner.nextLine();
        scheduleManager.removeTask(description);
    }

    private static void viewTasks(Scanner scanner, ScheduleManager scheduleManager) {
        scheduleManager.viewTasks();
    }

    private static void editTask(Scanner scanner, ScheduleManager scheduleManager) {
        System.out.println("Enter task description to edit:");
        String description = scanner.nextLine();
        System.out.println("Enter new task description:");
        String newDescription = scanner.nextLine();
        System.out.println("Enter new task start time (HH:mm):");
        String newStartTime = scanner.nextLine();
        System.out.println("Enter new task end time (HH:mm):");
        String newEndTime = scanner.nextLine();
        System.out.println("Enter new task priority (High, Medium, Low):");
        String newPriority = scanner.nextLine();

        scheduleManager.editTask(description, newDescription, newStartTime, newEndTime, newPriority);
    }

    private static void completeTask(Scanner scanner, ScheduleManager scheduleManager) {
        System.out.println("Enter task description to mark as completed:");
        String description = scanner.nextLine();
        scheduleManager.markTaskAsCompleted(description);
    }

    private static void viewTasksByPriority(Scanner scanner, ScheduleManager scheduleManager) {
        System.out.println("Enter priority level to view (High, Medium, Low):");
        String priority = scanner.nextLine();
        scheduleManager.viewTasksByPriority(priority);
    }
}
