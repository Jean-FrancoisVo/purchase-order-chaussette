package fr.lacombe.cuisine.purchaseorder.infra;

import org.springframework.stereotype.Repository;

@Repository
public class MealOrderRepository {
    private MealOrder mealOrderList;

    public MealOrderRepository() {
    }

    public void addMealOrder(MealOrder mealOrder) {
        this.mealOrderList = mealOrder;
    }

    public MealOrder getLastMealOrder() {
        return mealOrderList;
    }
}
