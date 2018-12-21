package fr.lacombe.cuisine.purchaseorder.infra;

import fr.lacombe.cuisine.purchaseorder.domain.Dish;
import fr.lacombe.cuisine.purchaseorder.domain.DishesReport;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PurchaseOrderController {
    private final Recipes recipes;

    public PurchaseOrderController(Recipes recipes) {
        this.recipes = recipes;
    }

    @GetMapping("/status")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/order")
    public String order(@RequestBody MealOrder mealOrder) {
        String dishName = mealOrder.getDishName();
        int dishQuantity = mealOrder.getDishQuantity();

        Optional<Dish> dish = recipes.retrieveDish(dishName);
        Dish realDish = dish.orElseThrow(RuntimeException::new);
        DishesReport dishesReport = new DishesReport(realDish, dishQuantity);

        return dishesReport.calculate().get(0).toString();
    }
}
