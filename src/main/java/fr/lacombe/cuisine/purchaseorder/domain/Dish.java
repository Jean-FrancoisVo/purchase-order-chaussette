package fr.lacombe.cuisine.purchaseorder.domain;

import java.util.HashMap;
import java.util.Map;

public class Dish {
    private Map<String, Integer> ingredients = new HashMap<>();

    public Dish(String ingredient, int quantity) {
        ingredients.put(ingredient, quantity);
    }

    public Map<String, Integer> mapIngredients() {
        return new HashMap<>(ingredients);
    }
}
