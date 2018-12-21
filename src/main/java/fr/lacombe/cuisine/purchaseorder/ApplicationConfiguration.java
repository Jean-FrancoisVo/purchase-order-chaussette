package fr.lacombe.cuisine.purchaseorder;

import fr.lacombe.cuisine.purchaseorder.domain.Dish;
import fr.lacombe.cuisine.purchaseorder.infra.Recipes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!test")
public class ApplicationConfiguration {
    @Bean
    public Recipes recipes() {
        Dish carrotSalad = new Dish("carrotSalad", "carrot", 1);
        Recipes recipes = new Recipes();
        recipes.addDish(carrotSalad);
        return recipes;
    }

}
