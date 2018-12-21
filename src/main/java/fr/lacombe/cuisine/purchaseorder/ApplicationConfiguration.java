package fr.lacombe.cuisine.purchaseorder;

import fr.lacombe.cuisine.purchaseorder.domain.Dish;
import fr.lacombe.cuisine.purchaseorder.domain.Ingredient;
import fr.lacombe.cuisine.purchaseorder.infra.Recipes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile("!test")
public class ApplicationConfiguration {
    @Bean
    public Recipes recipes() {
        Dish carrotSalad = new Dish("carrotSalad", "carrot", 1);
        Recipes recipes = new Recipes();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("tomato", 2));
        ingredients.add(new Ingredient("mozarella", 1));
        Dish tomatoMozarellaSalad = new Dish("Tomato mozarella",ingredients);
        recipes.addDish(carrotSalad);
        recipes.addDish(tomatoMozarellaSalad);
        return recipes;
    }

}
