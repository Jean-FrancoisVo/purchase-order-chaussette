package fr.lacombe.cuisine.purchaseorder.infra;

import fr.lacombe.cuisine.purchaseorder.domain.Dish;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    @Bean
    public Recipes recipes() {
        Recipes recipes = new Recipes();
        Dish carrotSalad = new Dish("carrotSalad", "carrot", 1);
        recipes.addDish(carrotSalad);
        return recipes;
    }

}
