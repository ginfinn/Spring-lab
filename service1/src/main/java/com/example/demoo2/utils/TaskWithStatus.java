package com.example.demoo2.utils;

import com.example.demoo2.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

@Setter
@Getter
@AllArgsConstructor
public class TaskWithStatus extends Task {

    TaskStatus taskStatus;

    public static TaskWithStatus taskWithStatus(Task task, TaskStatus taskStatus) {
        val taskWithStatus = new TaskWithStatus(taskStatus);
        taskWithStatus.setId(task.getId());
        taskWithStatus.setText(task.getText());
        taskWithStatus.setName(task.getName());
        taskWithStatus.setNicName(task.getNicName());
        taskWithStatus.setCreated(task.getCreated());
        return taskWithStatus;
    }
}
