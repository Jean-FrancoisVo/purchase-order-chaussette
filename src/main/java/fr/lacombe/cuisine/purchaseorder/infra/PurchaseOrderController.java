package fr.lacombe.cuisine.purchaseorder.infra;

import fr.lacombe.cuisine.purchaseorder.domain.Dish;
import fr.lacombe.cuisine.purchaseorder.domain.DishesReport;
import fr.lacombe.cuisine.purchaseorder.domain.PurchaseOrderLine;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PurchaseOrderController {
    private final Recipes recipes;
    private MealOrderRepository mealOrderRepository;

    public PurchaseOrderController(Recipes recipes, MealOrderRepository mealOrderRepository) {
        this.recipes = recipes;
        this.mealOrderRepository = mealOrderRepository;
    }

    @GetMapping("/purchase-order")
    public List<String> getPurchaseOrder() {
        MealOrder lastMealOrder = mealOrderRepository.getLastMealOrder();
        String dishName = lastMealOrder.getDishName();
        int dishQuantity = lastMealOrder.getDishQuantity();

        Optional<Dish> dish = recipes.retrieveDish(dishName);
        Dish realDish = dish.orElseThrow(RuntimeException::new);
        DishesReport dishesReport = new DishesReport(realDish, dishQuantity);

        return dishesReport.calculate().stream().map(PurchaseOrderLine::toString).collect(Collectors.toList());
    }

    @PostMapping("/order")
    public void order(@RequestBody MealOrder mealOrder) {
        this.mealOrderRepository.addMealOrder(mealOrder);
    }
}
