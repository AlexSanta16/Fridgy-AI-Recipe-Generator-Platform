package com.project.Fridgy.dto;

import lombok.Data;
import java.util.List;

@Data
public class DashboardStatsDTO {
    private long totalUsers;
    private long totalAdmins;
    private long totalNormalUsers;

    private long totalRecipes;
    private long totalFavorites;
    private long totalIngredients;

    private List<String> topFavoritedRecipes;
    private List<Object[]> topRecipeCreators;

}
