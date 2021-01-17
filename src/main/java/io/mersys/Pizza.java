package io.mersys;

import java.util.Arrays;

public class Pizza {

    public int count;
    public String[] ingredients;


    public Pizza(String count, String[] ingredients) {
        this.count = Integer.parseInt(count);
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "count=" + count +
                ", ingredients=" + Arrays.toString(ingredients) +
                '}';
    }
}
