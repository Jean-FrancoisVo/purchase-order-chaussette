package fr.lacombe.cuisine.purchaseorder.infra;

import cucumber.api.DataTable;
import cucumber.api.java8.En;
import org.assertj.core.api.Assertions;
import org.springframework.http.ResponseEntity;


public class PurchaseOrderControllerSteps extends CucumberRoot implements En {
    private ResponseEntity<String> response;

    public PurchaseOrderControllerSteps() {
        Given("^a carrot salad$", () -> {
            response = template.getForEntity("/order", String.class);
        });

        Then("^the ingredients should be$", (DataTable stringsDataTable) -> {

        });

        And("^(\\d+) person orders it$", (Integer arg0) -> {

        });

        Then("^the purchase order should be$", (DataTable purchaseOrders) -> {

        });
    }
}
