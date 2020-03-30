package com.example.demoo2.controller;

import com.example.demoo2.TaskStatus;
import com.example.demoo2.entity.Task;
import com.example.demoo2.entity.TaskStatusHistory;
import com.example.demoo2.repository.TaskRepository;
import com.example.demoo2.repository.TaskStatusHistoryRepositoty;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.TimeZone;

@RestController
public class MainController {
    @Autowired
    private TaskStatusHistoryRepositoty taskStatusHistoryRepositoty;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("create")
    public Integer createTask(@RequestParam String name, @RequestParam String text ) {
        TimeZone tz = TimeZone.getDefault();
        val now = LocalDate.now(tz.toZoneId());

        if(!taskRepository.findAllByNameAndCreatedBetween(name, Date.from(now.atStartOfDay().atZone(tz.toZoneId()).toInstant()), new Date()).isEmpty()) {
            throw new IllegalArgumentException("Name already used");
        }
        val task = Task.builder().name(name).text(text).build();
        return taskRepository.save(task).getId();
    }

    @GetMapping("get")
    public Task doGet(@RequestParam Integer id) {
        return taskRepository.findById(id).get();
    }
    @GetMapping("/change")
    public void changeTask(@RequestParam Integer id, @RequestParam TaskStatus status) {

        Task task = taskRepository.findById(id).get();

        task.setStatus(status);
        val historyTask = TaskStatusHistory.builder().newStatus(status).taskId(task.getId()).build();
        taskStatusHistoryRepositoty.save(historyTask);
        taskRepository.save(task);
    }
}
