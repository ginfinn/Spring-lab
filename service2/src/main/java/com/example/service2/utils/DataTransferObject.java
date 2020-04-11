package com.example.service2.utils;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataTransferObject {

    private  Integer taskId;
    private TaskStatus taskStatus;
}
