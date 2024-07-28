package com.schedulemanager.observer;
import com.schedulemanager.model.Task;

public class ConflictObserver implements TaskObserver {
    @Override
    public void notify(Task task) {
        System.out.println("Conflict detected with task: " + task);
    }
}
