package fr.lacombe.cuisine.purchaseorder;

import fr.lacombe.cuisine.purchaseorder.infra.Recipes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("")
public class ApplicationConfiguration {
    @Bean
    public Recipes recipes() {
        return new Recipes();
    }
}
