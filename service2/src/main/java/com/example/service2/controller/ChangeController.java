package com.example.service2.controller;

import com.example.service2.TaskStatus;
import com.example.service2.entity.TaskStatusHistory;
import com.example.service2.repository.TaskStatusHistoryRepositoty;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChangeController {
    @Autowired
    private TaskStatusHistoryRepositoty taskStatusHistoryRepositoty;
    @PutMapping("/change")
    public void changeTask(@RequestParam Integer id, @RequestParam TaskStatus status) {


        val historyTask = TaskStatusHistory.builder().newStatus(status).taskId(id).build();
        taskStatusHistoryRepositoty.save(historyTask);

    }
}
