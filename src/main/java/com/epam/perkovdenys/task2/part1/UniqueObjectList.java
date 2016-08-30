package com.epam.perkovdenys.task2.part1;

import java.util.*;


public class UniqueObjectList extends ArrayList {

    @Override
    public boolean add(Object o) {
        checkOccurrence(o);
        super.add(o);
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        findSimilar(c);
        super.addAll(c);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        findSimilar(c);
        super.add(index, c);
        return true;
    }

    @Override
    public Object set(int index, Object element) {
        checkOccurrence(element);
        Object object = super.get(index);
        super.set(index, element);
        return object;
    }

    @Override
    public void add(int index, Object element) {
        checkOccurrence(element);
        super.add(index, element);
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    private void checkOccurrence(Object o){
        if(super.contains(o)){
            throw new IllegalArgumentException();
        }
    }

    private void findSimilar(Collection c){
        //If the same elements in the Collection c - throw exception
        Set container = new HashSet<>(c);
        if(c.size() != container.size()){
            throw new IllegalArgumentException();
        }

        for(Object it : c){
            if(super.contains(it)){
                throw new IllegalArgumentException();
            }
        }
    }


}
