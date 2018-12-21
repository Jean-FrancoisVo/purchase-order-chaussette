package fr.lacombe.cuisine.purchaseorder.domain;

import java.util.*;

public class Dish {
    private List<Ingredient> ingredientList;

    private final String name;

    public Dish(final String name, final List<Ingredient> ingredients) {
        this.name = name;
        ingredientList = new ArrayList<>(ingredients);
    }

    public List<Ingredient> getIngredientList() {
        return Collections.unmodifiableList(this.ingredientList);
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

}
