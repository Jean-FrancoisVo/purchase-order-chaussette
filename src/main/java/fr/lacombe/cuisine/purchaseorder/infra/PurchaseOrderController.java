package fr.lacombe.cuisine.purchaseorder.infra;

import fr.lacombe.cuisine.purchaseorder.domain.Dish;
import fr.lacombe.cuisine.purchaseorder.domain.DishesReport;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PurchaseOrderController {
    private final Recipes recipes;
    private MealOrder currentMealOrder;

    public PurchaseOrderController(Recipes recipes) {
        this.recipes = recipes;
    }

    @GetMapping("/purchase-order")
    public String getPurchaseOrder() {
        String dishName = currentMealOrder.getDishName();
        int dishQuantity = currentMealOrder.getDishQuantity();

        Optional<Dish> dish = recipes.retrieveDish(dishName);
        Dish realDish = dish.orElseThrow(RuntimeException::new);
        DishesReport dishesReport = new DishesReport(realDish, dishQuantity);

        return dishesReport.calculate().get(0).toString();
    }

    @PostMapping("/order")
    public void order(@RequestBody MealOrder mealOrder) {
        this.currentMealOrder = mealOrder;
    }
}
