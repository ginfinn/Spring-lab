package com.example.demoo2.controller;

import com.example.demoo2.entity.Task;
import com.example.demoo2.repository.TaskRepository;
import com.example.demoo2.service.RestTemplateService;
import com.example.demoo2.utils.TaskStatus;
import com.example.demoo2.utils.TaskWithStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demoo2.utils.TaskStatus.*;

@RestController
public class FindController {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private RestTemplateService restTemplateService;

    @GetMapping("/find/undone")
    public List<Task> findAllUndone() {
        return findByStatus(UNDONE);
    }

    @GetMapping("/find/done")
    public List<Task> findAllDone() {

        return findByStatus(DONE);
    }

    @GetMapping("/find/arhive")
    public List<Task> findAllArhive() {

        return findByStatus(ARHIVE);
    }

    @GetMapping("/find/date")
    public List<Task> findAllByCreatedBetween(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date from,
                                              @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date to) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(to);
        cal.add(Calendar.DATE, 1);
        /*return restTemplateService.getAllStatus().stream()
                .map(dataTransferObject -> TaskWithStatus.taskWithStatus(
                taskRepository.findAllByCreatedBetween(from, cal.getTime()).get(),
                dataTransferObject.getTaskStatus()))
                .collect(Collectors.toList());*/
        return taskRepository.findAllByCreatedBetween(from, cal.getTime());


    }

    private List<Task> findByStatus(TaskStatus status) {
        return restTemplateService.getAllStatus()
                .stream()
                .filter(dataTransferObject -> dataTransferObject.getTaskStatus() == status)
                .map(dataTransferObject -> TaskWithStatus.taskWithStatus(
                        taskRepository.findById(dataTransferObject.getTaskId()).get(),
                        dataTransferObject.getTaskStatus()))
                .collect(Collectors.toList());
    }
}
