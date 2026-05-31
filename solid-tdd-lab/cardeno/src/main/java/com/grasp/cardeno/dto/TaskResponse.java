package com.grasp.cardeno.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor // This generates the constructor: TaskResponse(Long id, String title)
@NoArgsConstructor
public class TaskResponse {
    private Long id;
    private String title;
}