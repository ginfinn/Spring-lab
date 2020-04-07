package com.example.service2.entity;

import com.example.service2.TaskStatus;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class TaskStatusHistory {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    TaskStatus newStatus;
    @Builder.Default
    private Date created = new Date();
    private Integer taskId;

}
