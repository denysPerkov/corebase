package com.epam.perkovdenys.task1.part2;

import com.epam.perkovdenys.task1.part1.Food;

import java.util.*;

public class ProductContainer implements List<Food> {

    private static final int INIT_SIZE = 10;
    private Object[] arr;
    private int size = 0;

    public ProductContainer(){
        arr = new Object[INIT_SIZE];
    }

    @Override
    public int size() {
        int length = 0;

        for(int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                length++;
            }
        }

        return length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        boolean b = false;
        for (int i = 0; i < size(); i++) {
            if (arr[i].equals(o)) {
                b = true;
            }
        }
        
        return b;
    }

    @Override
    public Iterator<Food> iterator() {
        return new Itr();
    }

    public Iterator iterator(Filter filter){
        return new FilterIter(filter);
    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr, size());
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Food food) {
        if (size == arr.length)
            ensureCapacity();

        arr[size++] = food;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean bool = false;

        for (int i = 0; i < size(); ++i) {
            if ( arr[i].equals(o)) {
                for (int j = i; j < arr.length-1; j++) {
                    arr[j] = arr[j + 1];
                    bool = true;
                }
            }
        }
        size--;

        return bool;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends Food> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends Food> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Food get(int index) {
        checkIndex(index);
        return (Food) arr[index];
    }

    @Override
    public Food set(int index, Food element) {
        checkIndex(index);

        Object o = arr[index];
        arr[index] = element;

        return (Food) o;
    }

    @Override
    public void add(int index, Food element) {
        checkIndex(index);

        if(size() >= arr.length) {
            ensureCapacity();
        }

        for (int i = size(); i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = element;
        size++;
    }

    @Override
    public Food remove(int index) {
        Food food = null;

        for (int j = index; j < arr.length-1; j++) {
            arr[j] = arr[j + 1];
            food = (Food) arr[j];
        }
        size--;
        return food;
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<Food> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<Food> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Food> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    private void ensureCapacity() {
        int newCapacity = arr.length * 2;
        arr = Arrays.copyOf(arr, newCapacity);
    }

    private void ensureCapacity(int sz) {
        int newCapacity = arr.length + sz;
        arr = Arrays.copyOf(arr, newCapacity);
    }

    private void checkIndex(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Invalid index");
    }



    private class Itr implements Iterator {

        int cursor;
        int lastRet = -1;

        public boolean hasNext() {
            return cursor != size;
        }

        public Object next() {
            if (cursor >= size){
                throw new NoSuchElementException();
            }

            return  arr[cursor++];
        }
    }

    private class FilterIter extends Itr{

        Filter filter;

        FilterIter(Filter filter){
            this.filter = filter;
        }

        @Override
        public boolean hasNext() {
            for(int j= cursor; j < size; j++){
                Food food = (Food) arr[j];
                if(filter.apply(food)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public Object next() {
            if (cursor >= size) {
                throw new NoSuchElementException();
            }

            for(int j= cursor; j < size; j++){
                Food food = (Food) arr[j];
                if(filter.apply(food)) {
                    cursor = j+1;
                    return food;
                }
            }
            throw new NoSuchElementException();
        }
    }
}
