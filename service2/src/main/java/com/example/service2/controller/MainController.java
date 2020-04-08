package com.example.service2.controller;

import com.example.service2.utils.DataTransferObject;
import com.example.service2.utils.TaskStatus;
import com.example.service2.entity.TaskStatusHistory;
import com.example.service2.repository.TaskStatusHistoryRepositoty;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private TaskStatusHistoryRepositoty taskStatusHistoryRepositoty;
    @PutMapping("/change")
    public void changeTask(@RequestParam Integer id, @RequestParam TaskStatus status) {


        val historyTask = TaskStatusHistory.builder().newStatus(status).taskId(id).build();
        taskStatusHistoryRepositoty.save(historyTask);


        }
    @GetMapping("getStatusHistory")
    private List<DataTransferObject> doGetStatusHistory(){
        taskStatusHistoryRepositoty.findAll().stream().map(Integer);
       return DataTransferObject ;
    }
}
