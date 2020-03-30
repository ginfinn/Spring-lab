package com.example.demoo2.entity;

import com.example.demoo2.TaskStatus;
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
@Entity
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String text;
    //    private String tag;
    private String name;
    private String nicName;

    //    private String client;

@Builder.Default
private TaskStatus status  = TaskStatus.UNDONE;

@Builder.Default
    private Date created = new Date();
}

