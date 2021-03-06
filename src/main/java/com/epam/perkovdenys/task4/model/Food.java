package com.epam.perkovdenys.task4.model;

import com.epam.perkovdenys.task4.dao.impl.ProductsListDAOImpl;

import java.io.Serializable;


public  class Food implements Serializable{


    private int idProduct;
    private int cost;

    public Food(){
        setId();
    }

    public Food(int cost) {
        setId();
        setCost(cost);
    }

    public int getIdProduct(){
        return idProduct;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if(cost <= 0)
            throw new IllegalArgumentException("Incorrect cost");

        this.cost = cost;
    }

    private void setId(){
       this.idProduct = ProductsListDAOImpl.getInstance().getLastElement() + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Food food = (Food) o;

        return idProduct == food.idProduct;

    }

    @Override
    public int hashCode() {
        return idProduct;
    }

    @Override
    public String toString() {
        return "Food{" +
                "idProduct=" + idProduct +
                ", cost=" + cost +
                '}';
    }
}
