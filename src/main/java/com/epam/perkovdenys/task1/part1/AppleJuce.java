package com.epam.perkovdenys.task1.part1;

public class AppleJuce extends Drink {

    private String name;

    public AppleJuce(){}

    public AppleJuce(int cost, boolean alcohol, int volume, String name) {
        super(cost, alcohol, volume);
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

        AppleJuce appleJuce = (AppleJuce) o;

        return !(name != null ? !name.equals(appleJuce.name) : appleJuce.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AppleJuce{" +
                "name='" + name + '\'' +
                '}';
    }
}
