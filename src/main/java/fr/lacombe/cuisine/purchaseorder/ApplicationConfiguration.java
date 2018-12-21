package fr.lacombe.cuisine.purchaseorder;

import fr.lacombe.cuisine.purchaseorder.domain.Dish;
import fr.lacombe.cuisine.purchaseorder.domain.DishBuilder;
import fr.lacombe.cuisine.purchaseorder.domain.Ingredient;
import fr.lacombe.cuisine.purchaseorder.infra.Recipes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public Recipes recipes() {
        Dish carrotSalad = new DishBuilder().setName("carrotSalad").setIngredients(new Ingredient("carrot", 1)).createDish();
        Recipes recipes = new Recipes();
        Dish tomatoMozarellaSalad = new DishBuilder().setName("Tomato mozarella").setIngredients(new Ingredient("tomato", 2), new Ingredient("mozarella", 1)).createDish();
        recipes.addDish(tomatoMozarellaSalad);
        recipes.addDish(carrotSalad);
        return recipes;
    }

}
