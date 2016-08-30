package com.epam.perkovdenys.task5.part1.model;

import com.epam.perkovdenys.task5.part1.interfaces.ProductAccess;

public class Potatoes extends Entree {

    private String name;

    public Potatoes() {
    }

    public Potatoes(int cost, int minuts, int colorik, String name) {
        super(cost, minuts, colorik);
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @ProductAccess(name = "PRODUCT_NAME")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Potatoes potatoes = (Potatoes) o;

        return !(name != null ? !name.equals(potatoes.name) : potatoes.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Potatoes{" +
                "name='" + name + '\'' + " cost='" + super.getCost() + '\''
                + " colorik='" + super.getColorik() +'\'' +
                '}';
    }
}
