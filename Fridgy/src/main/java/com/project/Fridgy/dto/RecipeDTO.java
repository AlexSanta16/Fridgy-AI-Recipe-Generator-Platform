package com.project.Fridgy.dto;

import lombok.Data;

@Data
public class RecipeDTO {
    private Long id;
    private String title;
    private String instructions;
    private String authorName;
}
