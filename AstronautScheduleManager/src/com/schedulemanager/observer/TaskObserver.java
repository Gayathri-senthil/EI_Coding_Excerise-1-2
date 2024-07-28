package com.schedulemanager.observer;
import com.schedulemanager.model.Task;

public interface TaskObserver {
    void notify(Task task);
}
