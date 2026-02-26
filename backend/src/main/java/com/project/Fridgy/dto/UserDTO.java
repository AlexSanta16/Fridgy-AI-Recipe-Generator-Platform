package com.project.Fridgy.dto;

import com.project.Fridgy.model.Recipe;
import com.project.Fridgy.model.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private Role role;
    private List<Recipe> recipes;
    private List<Recipe> favoriteRecipes;
}
