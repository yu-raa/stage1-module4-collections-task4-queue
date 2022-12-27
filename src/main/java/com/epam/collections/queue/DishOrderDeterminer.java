package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> listAtFirst = new LinkedList<>();
        for (int i = 1; i <= numberOfDishes; i++) {
            listAtFirst.add(i);
        }

        List<Integer> listFinal = new ArrayList<>();
        int dishToEat = 0;

        while (!listAtFirst.isEmpty()) {
            dishToEat = (dishToEat + everyDishNumberToEat - 1) % listAtFirst.size();
            listFinal.add(listAtFirst.remove(dishToEat));
        }

        return listFinal;
    }
}
