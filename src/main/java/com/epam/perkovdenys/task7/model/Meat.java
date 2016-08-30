package com.epam.perkovdenys.task7.model;

import com.epam.perkovdenys.task7.interfaces.Getter;
import com.epam.perkovdenys.task7.interfaces.ProductAccess;

public class Meat extends Entree {

    private String name;

    public Meat() {
    }

    public Meat(int cost, int minuts, int colorik, String name) {
        super(cost, minuts, colorik);
        this.name = name;
    }

    @Getter
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

        Meat meat = (Meat) o;

        return !(name != null ? !name.equals(meat.name) : meat.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Meat{" +
                "name='" + name + '\'' + " cost='" + super.getCost() + '\''
                + " colorik='" + super.getColorik() +'\'' + "id" + super.getIdProduct() +
                '}';
    }
}
