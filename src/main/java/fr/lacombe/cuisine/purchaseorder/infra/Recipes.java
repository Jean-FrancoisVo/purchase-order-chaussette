package fr.lacombe.cuisine.purchaseorder.infra;

import fr.lacombe.cuisine.purchaseorder.domain.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Recipes {

    private List<Dish> dishes = new ArrayList<>();

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public Optional<Dish> retrieveDish(String name) {
        return dishes.stream()
                .filter(dish -> dish.hasName(name))
                .findAny();
    }

}
