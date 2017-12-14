package com.lbuthman.recipes.controllers;

import com.lbuthman.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "index"})
    public String getIndex(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        log.debug("Getting Index page.");
        return "index";
    }
}
