package com.epam.perkovdenys.task5.part2;

import com.epam.perkovdenys.task4.dao.impl.ProductsListDAOImpl;
import java.io.Serializable;

public  class PotatoesImpl implements Potatoes{

    private int idProduct;
    private int cost;
    private int colorik;
    private String name;

    public PotatoesImpl(){
        setId();
    }

    public int getIdProduct(){
        return idProduct;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getColorik() {
        return colorik;
    }

    public void setColorik(int colorik) {
        this.colorik = colorik;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setId(){
        this.idProduct = ProductsListDAOImpl.getInstance().getLastElement() + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PotatoesImpl potatoes = (PotatoesImpl) o;

        return idProduct == potatoes.idProduct;

    }

    @Override
    public int hashCode() {
        return idProduct;
    }

    @Override
    public String toString() {
        return "Potatoes{" +
                "idProduct=" + idProduct +
                ", cost=" + cost + ", name=" + name +
                '}';
    }
}
