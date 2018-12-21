package fr.lacombe.cuisine.purchaseorder.infra;

import cucumber.api.DataTable;
import cucumber.api.java8.En;
import fr.lacombe.cuisine.purchaseorder.domain.Dish;
import fr.lacombe.cuisine.purchaseorder.domain.Ingredient;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseOrderControllerSteps extends CucumberRoot implements En {

    public PurchaseOrderControllerSteps(Recipes recipes) {
        Given("^a carrot salad$", () -> {

        });

        Then("^the ingredients should be$", (DataTable stringsDataTable) -> {
            Optional<Dish> carrotSalad = recipes.retrieveDish("carrotSalad");

            Optional<Map<String, Integer>> ingredientList = carrotSalad.map(Dish::mapIngredients);

            Map<String, Integer> saladCarrotIngredientList = stringsDataTable.asList(Ingredient.class).stream()
                    .collect(toMap(Ingredient::getName, Ingredient::getQuantity));
            assertThat(ingredientList).isEqualTo(Optional.of(saladCarrotIngredientList));
        });

        And("^(\\d+) person orders it$", (Integer arg0) -> {
            MealOrder carrotSalad = new MealOrder("carrotSalad", arg0);
            HttpEntity<MealOrder> request = new HttpEntity<>(carrotSalad);
            template.postForEntity("/order", request, String.class);
        });

        Then("^the purchase order should be$", (DataTable purchaseOrders) -> {
            ResponseEntity<String> response = template.getForEntity("/purchase-order", String.class);
            assertThat(response.getBody()).isEqualTo("carrot | 2");
        });
    }
}
