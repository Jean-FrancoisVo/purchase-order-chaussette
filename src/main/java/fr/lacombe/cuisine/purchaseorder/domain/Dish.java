package fr.lacombe.cuisine.purchaseorder.domain;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Dish {
    private List<Ingredient> ingredientList = new ArrayList<>();

    public Dish(String name, String ingredient, int quantity) {
        this.name = name;
        ingredientList.add(new Ingredient(ingredient,quantity));
    }
    private final String name;

    public Dish(final String name, final List<Ingredient> ingredients) {
        this.name = name;
        ingredientList = new ArrayList<>(ingredients);
    }


    public Map<String, Integer> mapIngredients() {
        return ingredientList.stream().collect(toMap(Ingredient::getName,Ingredient::getQuantity));
    }

    public List<Ingredient> getIngredientList() {
        return Collections.unmodifiableList(this.ingredientList);
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }


}
