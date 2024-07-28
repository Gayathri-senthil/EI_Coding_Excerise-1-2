package com.schedulemanager.singleton;
import com.schedulemanager.model.Task;
import com.schedulemanager.observer.TaskObserver;
import com.schedulemanager.util.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<TaskObserver> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public void addTask(Task task) {
        if (!validateTask(task)) {
            for (TaskObserver observer : observers) {
                observer.notify(task);
            }
            Logger.log("Conflict detected: " + task);
            return;
        }
        tasks.add(task);
        System.out.println("Task added successfully: " + task);
        Logger.log("Task added: " + task);
    }

    public void removeTask(String description) {
        Task taskToRemove = findTask(description);
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Task removed successfully: " + description);
            Logger.log("Task removed: " + description);
        } else {
            System.out.println("Error: Task not found");
            Logger.log("Error: Task not found - " + description);
        }
    }

    public void viewTasks() {
        Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void viewTasksByPriority(String priority) {
        tasks.stream()
                .filter(task -> task.getPriority().equalsIgnoreCase(priority))
                .sorted(Comparator.comparing(Task::getStartTime))
                .forEach(System.out::println);
    }

    public void markTaskAsCompleted(String description) {
        Task task = findTask(description);
        if (task != null) {
            task.setCompleted(true);
            System.out.println("Task marked as completed: " + description);
            Logger.log("Task completed: " + description);
        } else {
            System.out.println("Error: Task not found");
            Logger.log("Error: Task not found - " + description);
        }
    }

    public void editTask(String description, String newDescription, String newStartTime, String newEndTime, String newPriority) {
        Task task = findTask(description);
        if (task != null) {
            task.setDescription(newDescription);
            task.setStartTime(newStartTime);
            task.setEndTime(newEndTime);
            task.setPriority(newPriority);
            System.out.println("Task updated successfully: " + task);
            Logger.log("Task updated: " + task);
        } else {
            System.out.println("Error: Task not found");
            Logger.log("Error: Task not found - " + description);
        }
    }

    private Task findTask(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                return task;
            }
        }
        return null;
    }

    private boolean validateTask(Task newTask) {
        for (Task task : tasks) {
            if (isOverlapping(task, newTask)) {
                System.out.println("Error: Task conflicts with existing task \"" + task.getDescription() + "\"");
                Logger.log("Conflict detected: " + task);
                return false;
            }
        }
        return true;
    }

    private boolean isOverlapping(Task task1, Task task2) {
        return !(task1.getEndTime().compareTo(task2.getStartTime()) <= 0 ||
                task2.getEndTime().compareTo(task1.getStartTime()) <= 0);
    }
}

