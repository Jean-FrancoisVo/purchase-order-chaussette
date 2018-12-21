package fr.lacombe.cuisine.purchaseorder.domain;

import cucumber.api.DataTable;
import cucumber.api.java8.En;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseOrderSteps implements En {

    private Dish carrotSalad;
    private int nbPeople;

    public PurchaseOrderSteps() {
        Given("^a carrot salad$", () ->
                carrotSalad = new Dish("carrotSalad", "carrot", 1)
        );

        Then("^the ingredients should be$", (DataTable stringsDataTable) -> {
            Map<String, Integer> expected = new HashMap<>();
            stringsDataTable.asList(Ingredient.class)
                    .forEach(ingredient -> expected.put(ingredient.getName(), ingredient.getQuantity()));
            assertThat(carrotSalad.mapIngredients()).isEqualTo(expected);
        });

        And("^(\\d+) person orders it$", (Integer arg0) -> {
            this.nbPeople = arg0;
        });

        Then("^the purchase order should be$", (DataTable purchaseOrders) -> {
            List<PurchaseOrderLine> expected = new ArrayList<>();
            purchaseOrders.asList(PurchaseOrderLine.class)
                    .forEach(line -> expected.add(new PurchaseOrderLine(line.getProduct(), line.getQuantity())));
            DishesReport dishesReport = new DishesReport(this.carrotSalad, nbPeople);
            assertThat(dishesReport.calculate()).isEqualTo(expected);
        });
    }

}
