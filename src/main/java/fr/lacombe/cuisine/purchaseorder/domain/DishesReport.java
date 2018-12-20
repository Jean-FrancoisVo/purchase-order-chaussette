package fr.lacombe.cuisine.purchaseorder.domain;

import java.util.ArrayList;
import java.util.List;

public class DishesReport {
    private final Dish dish;
    private final int dishQuantity;

    public DishesReport(Dish dish, int dishQuantity) {
        this.dish = dish;
        this.dishQuantity = dishQuantity;
    }

    public List<PurchaseOrderLine> calculate() {
        ArrayList<PurchaseOrderLine> purchaseOrderLines = new ArrayList<>();
        dish.mapIngredients().forEach((ingredientName, ingredientQuantity) -> {
            PurchaseOrderLine purchaseOrderLine = new PurchaseOrderLine(ingredientName, ingredientQuantity * dishQuantity);
            purchaseOrderLines.add(purchaseOrderLine);
        });
        return purchaseOrderLines;
    }
}
