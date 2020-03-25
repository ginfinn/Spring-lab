package com.example.demoo2;


import ch.qos.logback.core.net.server.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Task,Long> {
}
