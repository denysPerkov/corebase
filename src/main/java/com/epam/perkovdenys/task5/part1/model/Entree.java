package com.epam.perkovdenys.task5.part1.model;

import com.epam.perkovdenys.task5.part1.interfaces.ProductAccess;

public abstract class Entree extends Food {

    private int minuts;
    private int colorik;

    public Entree(){}

    public Entree(int cost, int minuts, int colorik) {
        super(cost);
        setMinuts(minuts);
        setColorik(colorik);
    }


    public int getMinuts() {
        return minuts;
    }

    @ProductAccess(name = "PRODUCT_MINUTS")
    public void setMinuts(int minuts) {
        if(minuts < 0)
            throw new IllegalArgumentException("Incorrect time");

        this.minuts = minuts;
    }


    public int getColorik() {
        return colorik;
    }

    @ProductAccess(name = "PRODUCT_COLORIK")
    public void setColorik(int colorik) {
        if(colorik < 0)
            throw new IllegalArgumentException("Incorrect colorik");

        this.colorik = colorik;
    }

    @Override
    public String toString() {
        return "Entree{" +
                "minuts=" + minuts +
                ", colorik=" + colorik +
                '}';
    }
}
