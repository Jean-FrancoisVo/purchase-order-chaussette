package fr.lacombe.cuisine.purchaseorder.domain;

import cucumber.api.DataTable;
import cucumber.api.java8.En;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseOrderSteps implements En {

    private Dish carrotSalad;
    private int nbPeople;

    public PurchaseOrderSteps() {
        Given("^a carrot salad$", () ->
                carrotSalad = new DishBuilder()
                        .setName("carrotSalad")
                        .setIngredients(new Ingredient("carrot", 1)).createDish()
        );

        Then("^the ingredients should be$", (DataTable stringsDataTable) -> {
            Map<String, Integer> expected = new HashMap<>();
            List<Ingredient> ingredients = stringsDataTable.asList(Ingredient.class);
             stringsDataTable.asList(Ingredient.class).stream()
                    .forEach(ingredient -> expected.put(ingredient.getName(), ingredient.getQuantity()));
            assertThat(carrotSalad.getIngredientList()).isEqualTo(ingredients);
        });

        And("^(\\d+) person orders it$", (Integer arg0) -> {
            this.nbPeople = arg0;
        });

        Then("^the purchase order should be$", (DataTable purchaseOrders) -> {
            List<PurchaseOrderLine> expected = new ArrayList<>();
            purchaseOrders.asList(PurchaseOrderLine.class).stream()
                    .forEach(line -> expected.add(new PurchaseOrderLine(line.getProduct(), line.getQuantity())));
            DishesReport dishesReport = new DishesReport(this.carrotSalad, nbPeople);
            assertThat(dishesReport.calculate()).isEqualTo(expected);
        });
        Given("^a tomato mozarella salad$", () -> {
            carrotSalad = new DishBuilder().setName("Tomato mozarella").setIngredients(new Ingredient("tomato", 2), new Ingredient("mozarella", 1)).createDish();
            // Write code here that turns the phrase above into concrete actions
        });
    }

}
