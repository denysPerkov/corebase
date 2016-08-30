package com.epam.perkovdenys.task1.part1;

public class Drink extends Food {

    private boolean alcohol;
    private int volume;

    public Drink(){}

    public Drink(int cost, boolean alcohol, int volume) {
        super(cost);
        this.alcohol = alcohol;
        this.volume = volume;
    }

    public boolean isAlcohol() {
        return alcohol;
    }

    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
