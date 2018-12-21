package fr.lacombe.cuisine.purchaseorder.domain;

import java.util.Arrays;
import java.util.List;

public class DishBuilder {
    private String name;
    private List<Ingredient> ingredients;

    public DishBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DishBuilder setIngredients(Ingredient... ingredients) {
        this.ingredients = Arrays.asList(ingredients);
        return this;
    }

    public Dish createDish() {
        return new Dish(name, ingredients);
    }
}