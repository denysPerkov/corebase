package com.epam.perkovdenys.task4.model;

public class Entree extends Food {

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

    public void setMinuts(int minuts) {
        if(minuts < 0)
            throw new IllegalArgumentException("Incorrect time");

        this.minuts = minuts;
    }

    public int getColorik() {
        return colorik;
    }

    public void setColorik(int colorik) {
        if(colorik < 0)
            throw new IllegalArgumentException("Incorrect colorik");

        this.colorik = colorik;
    }


}
