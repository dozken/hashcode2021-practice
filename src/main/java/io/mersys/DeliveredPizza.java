package io.mersys;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class DeliveredPizza {

    public int team;
    public List<Integer> pizzaIndexes;

    @Override
    public String toString() {
        return team + " " + pizzaIndexes.stream().map(x->x.toString()).collect(joining(" "));
    }
}
