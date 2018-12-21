package fr.lacombe.cuisine.purchaseorder.infra;

import cucumber.api.DataTable;
import cucumber.api.java8.En;
import fr.lacombe.cuisine.purchaseorder.domain.Dish;
import fr.lacombe.cuisine.purchaseorder.domain.Ingredient;
import fr.lacombe.cuisine.purchaseorder.domain.PurchaseOrderLine;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseOrderControllerSteps extends CucumberRoot implements En {

    private String currentDishName;
    private Optional<Dish> currentRecipe;

    public PurchaseOrderControllerSteps(Recipes recipes) {
        Given("^a carrot salad$", () -> {
            currentDishName = "carrotSalad";
            currentRecipe = recipes.retrieveDish(currentDishName);
        });

        Then("^the ingredients should be$", (DataTable stringsDataTable) -> {

            Optional<List<Ingredient>> ingredientList = currentRecipe.map(Dish::getIngredientList);

            List<Ingredient> saladCarrotIngredientList = stringsDataTable.asList(Ingredient.class);
            assertThat(ingredientList).isEqualTo(Optional.of(saladCarrotIngredientList));
        });

        And("^(\\d+) person orders it$", (Integer arg0) -> {
            MealOrder carrotSalad = new MealOrder(currentDishName, arg0);
            HttpEntity<MealOrder> request = new HttpEntity<>(carrotSalad);
            template.postForEntity("/order", request, String.class);
        });

        Then("^the purchase order should be$", (DataTable purchaseOrders) -> {
            ResponseEntity<List> response = template.getForEntity("/purchase-order", List.class);
            List<String> result = purchaseOrders.asList(PurchaseOrderLine.class).stream()
                    .map(PurchaseOrderLine::toString)
                    .collect(Collectors.toList());
            assertThat(response.getBody()).isEqualTo(result);
        });

        Given("^a tomato mozarella salad$", () -> {
            currentDishName = "Tomato mozarella";
            currentRecipe = recipes.retrieveDish(currentDishName);
        });
    }
}
