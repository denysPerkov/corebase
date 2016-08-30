package com.epam.perkovdenys.task1.part1;

public  class Food {

    private int cost;

    public Food(){}

    public Food(int cost) {
       setCost(cost);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if(cost <= 0)
            throw new IllegalArgumentException("Incorrect cost");

        this.cost = cost;
    }


    @Override
    public String toString() {
        return "Food{" +
                "cost=" + cost + "}";}
}
