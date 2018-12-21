package fr.lacombe.cuisine.purchaseorder.domain;

import java.util.HashMap;
import java.util.Map;

public class Dish {
    private final String name;
    private Map<String, Integer> ingredients = new HashMap<>();

    public Dish(String name, String ingredient, int quantity) {
        this.name = name;
        ingredients.put(ingredient, quantity);
    }

    public Map<String, Integer> mapIngredients() {
        return new HashMap<>(ingredients);
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }
}
