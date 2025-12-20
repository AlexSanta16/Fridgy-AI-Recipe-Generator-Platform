package com.project.Fridgy.controller;

import com.project.Fridgy.model.Recipe;
import com.project.Fridgy.service.ExploreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExploreController {

    private final ExploreService exploreService;

    public ExploreController(ExploreService exploreService) {
        this.exploreService = exploreService;
    }

    @GetMapping("/api/explore")
    public List<Recipe> getFavoritedRecipes() {
        return exploreService.getFavoritedRecipes();
    }
}
