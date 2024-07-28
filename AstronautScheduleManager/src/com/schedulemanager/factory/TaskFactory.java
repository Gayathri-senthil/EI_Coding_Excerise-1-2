package com.schedulemanager.factory;


import com.schedulemanager.model.Task;

public class TaskFactory {
    public static Task createTask(String description, String startTime, String endTime, String priority) {
        return new Task(description, startTime, endTime, priority);
    }
}
