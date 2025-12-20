package com.project.Fridgy.controller;

import com.project.Fridgy.service.AiRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fridgy")
public class AiRecipeController {

    @Autowired
    private AiRecipeService aiRecipeService;

    private List<String> promptIngredients = new ArrayList<>();

    @PostMapping("/ingredients")
    public void receiveIngredients(@RequestBody List<String> ingredients) {
        this.promptIngredients = ingredients;

    }

    @GetMapping
    public String generateRecipeForProduct(@RequestHeader("Authorization") String authHeader) {
        String joinedIngredients = String.join(", ", promptIngredients);


        String prompt = """
        Generate a perfect recipe using ONLY the given ingredients. 
        Write in English in a clear, friendly style. Use bullet points for readability. 
        Include all necessary details to cook it perfectly, but keep the total text under 200 words.
        
        Format the response like this:
        
        🍽 Recipe Title 
        • ⏱ Prep time: X min
        • 🍳 Cook time: X min
        • 🥄 Servings: X
        • Ingredients:
          - 200g pasta 🍝
          - 50g cheese 🧀
          - 2 eggs 🥚
          - 1 tbsp olive oil 🫒
          (list all ingredients with quantities and emoji)
        
        • Steps:
          • Step 1: Short, clear instruction using ingredients, add emoji.  
          • Step 2: Next step.  
          • Step 3: Continue until recipe is done.  
        
        • 🍴 Tips: Optional tips, plating suggestions, or flavor enhancers. 😋
        
        Ingredients: """ + joinedIngredients;


        String recipeText = aiRecipeService.generateRecipe(prompt);
        aiRecipeService.saveRecipe(recipeText, authHeader);
        aiRecipeService.linkRecipeWithIngredients(joinedIngredients);

        return recipeText;
    }
}
