package com.example.demoo2.controller;

import com.example.demoo2.TaskStatus;
import com.example.demoo2.entity.Task;
import com.example.demoo2.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class FindController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/find/undone")
    public List<Task> findAllUndone() {
        return taskRepository.findAllByStatus(TaskStatus.UNDONE);
    }

    @GetMapping("/find/done")
    public List<Task> findAllDone() {
        return taskRepository.findAllByStatus(TaskStatus.DONE);
    }

    @GetMapping("/find/arhiv")
    public List<Task> findAllArhive() {
        return taskRepository.findAllByStatus(TaskStatus.ARHIV);
    }


    @GetMapping("/find/date")
    public List<Task> findAllByDate(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date from, @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date to) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(to);
        cal.add(Calendar.DATE, 1); 
        return taskRepository.findAllByCreatedBetween(from, cal.getTime());

    }


}
