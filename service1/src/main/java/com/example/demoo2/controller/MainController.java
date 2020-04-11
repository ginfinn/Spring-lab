package com.example.demoo2.controller;

import com.example.demoo2.entity.Task;
import com.example.demoo2.repository.TaskRepository;

import com.example.demoo2.service.RestTemplateService;
import com.example.demoo2.utils.TaskStatus;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.TimeZone;

@RestController
public class MainController {

    @Autowired
    RestTemplateService restTemplateService;

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("create")
    @Transactional
    public Integer createTask(@RequestParam String nicName, @RequestParam String name, @RequestParam String text) {
        TimeZone tz = TimeZone.getDefault();
        val now = LocalDate.now(tz.toZoneId());

        if (!taskRepository.findAllByNicNameAndNameAndCreatedBetween(nicName, name, Date.from(now.atStartOfDay().atZone(tz.toZoneId()).toInstant()), new Date()).isEmpty()) {
            throw new IllegalArgumentException("Name already used");
        }

        val task = Task.builder().nicName(nicName).name(name).text(text).build();
        val id = taskRepository.save(task).getId();
        restTemplateService.changeStatus(id, TaskStatus.UNDONE);
        return id;
    }

    @GetMapping("get")
    public Task doGet(@RequestParam Integer id) {
        return taskRepository.findById(id).get();
    }
}
