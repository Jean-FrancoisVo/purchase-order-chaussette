package fr.lacombe.cuisine.purchaseorder.infra;

public class MealOrder {
    private String dishName;
    private int dishQuantity;

    public MealOrder(String dishName, int dishQuantity) {
        this.dishName = dishName;
        this.dishQuantity = dishQuantity;
    }

    public String getDishName() {
        return dishName;
    }

    public int getDishQuantity() {
        return dishQuantity;
    }
}
