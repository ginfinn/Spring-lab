package com.example.demoo2.repository;


import com.example.demoo2.TaskStatus;
import com.example.demoo2.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    public List<Task> findAllByStatus(TaskStatus status);

    public List<Task> findAllByCreatedBetween(Date from, Date to);

    public List<Task> findAllByNicNameAndNameAndCreatedBetween(String nicName ,String name, Date from, Date to);


}
