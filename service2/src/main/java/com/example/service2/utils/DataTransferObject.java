package com.example.service2.utils;

import com.example.service2.entity.TaskStatusHistory;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataTransferObject {
    @Autowired
   private TaskStatusHistory taskStatusHistory;

    private  Integer taskId;
    private TaskStatus taskStatus;
}
