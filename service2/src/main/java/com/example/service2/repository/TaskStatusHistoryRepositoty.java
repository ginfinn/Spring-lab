package com.example.service2.repository;

import com.example.service2.entity.TaskStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatusHistoryRepositoty extends JpaRepository<TaskStatusHistory, Integer> {
}
