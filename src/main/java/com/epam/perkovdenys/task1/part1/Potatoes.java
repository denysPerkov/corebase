package com.epam.perkovdenys.task1.part1;

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
                "name='" + name + '\'' +
                '}';
    }
}
