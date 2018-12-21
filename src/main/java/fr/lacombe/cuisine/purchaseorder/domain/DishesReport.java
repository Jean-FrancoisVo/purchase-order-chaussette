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
        dish.getIngredientList().forEach((ingredient) -> {
            PurchaseOrderLine purchaseOrderLine = new PurchaseOrderLine(ingredient.getName(), ingredient.getQuantity() * dishQuantity);
            purchaseOrderLines.add(purchaseOrderLine);
        });
        return purchaseOrderLines;
    }
}
