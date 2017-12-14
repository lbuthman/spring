package com.lbuthman.recipes.bootstrap;

import com.lbuthman.recipes.domain.*;
import com.lbuthman.recipes.repositories.CategoryRepository;
import com.lbuthman.recipes.repositories.RecipeRespository;
import com.lbuthman.recipes.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRespository recipeRespository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRespository recipeRespository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRespository = recipeRespository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRespository.saveAll(getRecipes());
        log.debug("Loading recipe bootstrap data.");
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>(2);

        /*
         * Prepare Units of Measure from repository
         * */
        Optional<UnitOfMeasure> teaspoonOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if (!teaspoonOptional.isPresent()) { throw new RuntimeException("Unit of Measure 'Teaspoon' Not Found.");}
        Optional<UnitOfMeasure> tablespoonOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if (!tablespoonOptional.isPresent()) { throw new RuntimeException("Unit of Measure 'Tablespoon' Not Found.");}
        Optional<UnitOfMeasure> dashOptional = unitOfMeasureRepository.findByDescription("Dash");
        if (!dashOptional.isPresent()) { throw new RuntimeException("Unit of Measure 'Dash' Not Found.");}
        Optional<UnitOfMeasure> cupOptional = unitOfMeasureRepository.findByDescription("Cup");
        if (!cupOptional.isPresent()) { throw new RuntimeException("Unit of Measure 'Cup' Not Found.");}
        Optional<UnitOfMeasure> pintOptional = unitOfMeasureRepository.findByDescription("Pint");
        if (!pintOptional.isPresent()) { throw new RuntimeException("Unit of Measure 'Pint' Not Found.");}
        Optional<UnitOfMeasure> eachOptional = unitOfMeasureRepository.findByDescription("Each");
        if (!eachOptional.isPresent()) { throw new RuntimeException("Unit of Measure 'Each' Not Found.");}

        /*
        * Get Units of Measure from found items in repository
        * */
        UnitOfMeasure teaspoon = teaspoonOptional.get();
        UnitOfMeasure tablespoon = tablespoonOptional.get();
        UnitOfMeasure dash = dashOptional.get();
        UnitOfMeasure cup = cupOptional.get();
        UnitOfMeasure pint = pintOptional.get();
        UnitOfMeasure each = eachOptional.get();

        /*
         * Prepare Categories from repository
         * */
        Optional<Category> americanOptional = categoryRepository.findByDescription("American");
        if (!americanOptional.isPresent()) { throw new RuntimeException("Category Not Found.");}
        Optional<Category> mexicanOptional = categoryRepository.findByDescription("Mexican");
        if (!mexicanOptional.isPresent()) { throw new RuntimeException("Category Not Found.");}

        /*
         * Get Categories from found items in repository
         * */
        Category americanCategory = americanOptional.get();
        Category mexicanCategory = mexicanOptional.get();

        /*
         * CREATE Guacamole Recipe
         * */
        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setDescription("Perfect Guacamole");
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setCookTime(0);
        guacamoleRecipe.setServings(3);
        guacamoleRecipe.setSource("Simply Recipes");
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        guacamoleRecipe.getCategories().add(mexicanCategory);
        guacamoleRecipe.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamoleRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");
//        guacamoleRecipe.setImage();

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.");
        guacamoleRecipe.setNotes(guacNotes);

        guacamoleRecipe.addIngredient(new Ingredient("Ripe avocados", new BigDecimal(2), each));
        guacamoleRecipe.addIngredient(new Ingredient("Kosher salt", new BigDecimal(.5), teaspoon));
        guacamoleRecipe.addIngredient(new Ingredient("Fresh lime or lemon juice", new BigDecimal(1), tablespoon));
        guacamoleRecipe.addIngredient(new Ingredient("Minced red onion or thinly sliced green onion", new BigDecimal(2), tablespoon));
        guacamoleRecipe.addIngredient(new Ingredient("Serrano chiles, stems and seeds removed, minced", new BigDecimal(1), each));
        guacamoleRecipe.addIngredient(new Ingredient("Cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), tablespoon));
        guacamoleRecipe.addIngredient(new Ingredient("Freshly grated black pepper", new BigDecimal(1), dash));
        guacamoleRecipe.addIngredient(new Ingredient("Ripe tomato, seeds and pulp removed, chopped", new BigDecimal(1), each));

        /*
         * CREATE Chicken Tacos Recipe
         * */
        Recipe chickenTacosRecipe = new Recipe();
        chickenTacosRecipe.setDescription("Spicy Grilled Chicken Tacos");
        chickenTacosRecipe.setPrepTime(20);
        chickenTacosRecipe.setCookTime(15);
        chickenTacosRecipe.setServings(5);
        chickenTacosRecipe.setSource("Simply Recipes");
        chickenTacosRecipe.setDifficulty(Difficulty.MEDIUM);
        chickenTacosRecipe.getCategories().add(americanCategory);
        chickenTacosRecipe.getCategories().add(mexicanCategory);
        chickenTacosRecipe.setUrl("http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        chickenTacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!");
        chickenTacosRecipe.setNotes(tacoNotes);

        chickenTacosRecipe.addIngredient(new Ingredient("Ancho chili powder", new BigDecimal(2), tablespoon));
        chickenTacosRecipe.addIngredient(new Ingredient("Dried oregano", new BigDecimal(1), teaspoon));
        chickenTacosRecipe.addIngredient(new Ingredient("Dried cumin", new BigDecimal(1), teaspoon));
        chickenTacosRecipe.addIngredient(new Ingredient("Sugar", new BigDecimal(1), teaspoon));
        chickenTacosRecipe.addIngredient(new Ingredient("Salt", new BigDecimal(.5), teaspoon));
        chickenTacosRecipe.addIngredient(new Ingredient("Clove garlic, finely chopped", new BigDecimal(1), each));
        chickenTacosRecipe.addIngredient(new Ingredient("Finely grated orange zest", new BigDecimal(1), tablespoon));
        chickenTacosRecipe.addIngredient(new Ingredient("Fresh-squeezed orange juice", new BigDecimal(3), tablespoon));
        chickenTacosRecipe.addIngredient(new Ingredient("Olive oil", new BigDecimal(2), tablespoon));
        chickenTacosRecipe.addIngredient(new Ingredient("Skinless, boneless chicken thighs", new BigDecimal(4), each));
        chickenTacosRecipe.addIngredient(new Ingredient("Small corn tortillas", new BigDecimal(8), each));
        chickenTacosRecipe.addIngredient(new Ingredient("Packed baby arugula", new BigDecimal(3), cup));
        chickenTacosRecipe.addIngredient(new Ingredient("Medium ripe avocados, sliced", new BigDecimal(2), each));
        chickenTacosRecipe.addIngredient(new Ingredient("Radishes, thinly sliced", new BigDecimal(4), each));
        chickenTacosRecipe.addIngredient(new Ingredient("Cherry tomatoes, halved", new BigDecimal(.5), pint));
        chickenTacosRecipe.addIngredient(new Ingredient("Red onion, thinly sliced", new BigDecimal(.25), each));
        chickenTacosRecipe.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(1), tablespoon));
        chickenTacosRecipe.addIngredient(new Ingredient("Sour cream thinned with 1/4 cup milk", new BigDecimal(.5), cup));
        chickenTacosRecipe.addIngredient(new Ingredient("Lime, cut into wedges", new BigDecimal(1), each));

        recipes.add(guacamoleRecipe);
        recipes.add(chickenTacosRecipe);
        return recipes;
    }
}