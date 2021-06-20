package animals;

import foods.Food;
import foods.Grass;

public abstract class Herbivore extends Animal {

    @Override
    public String eat(Food food) {

        if (food instanceof Grass) {
            return " съела " + food.getName();
        } else {
            return " не ест " + food.getName();
        }
    }
}
