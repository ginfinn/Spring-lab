package com.example.demoo2.controller;

import com.example.demoo2.entity.Task;
import com.example.demoo2.repository.TaskRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
public class MainController {

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
}
