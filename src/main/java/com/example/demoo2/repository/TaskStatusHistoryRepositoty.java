package com.example.demoo2.repository;

import com.example.demoo2.entity.TaskStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatusHistoryRepositoty extends JpaRepository<TaskStatusHistory, Integer> {

    }

