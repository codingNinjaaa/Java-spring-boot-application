package com.example.javaspringapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HeartbeatDto {
    private String applicationName;
    private String applicationStatus;
    private String timestamp;
}
