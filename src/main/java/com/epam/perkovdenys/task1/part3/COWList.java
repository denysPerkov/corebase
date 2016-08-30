package com.epam.perkovdenys.task1.part3;

import java.util.*;

public class COWList<E> implements List<E> {

    private static final int INIT_SIZE = 10;
    private Object[] arr;
    private int size = 0;

    private Object[] getArr() {
        return arr;
    }

    private void setArr(Object[] a) {
        arr = a;
    }

    public COWList(){ setArr(new Object[0]); }

    @Override
    public int size() {
        return getArr().length;
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
    public Iterator<E> iterator() {
        return new CopyOnWriteIterator(getArr());
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr, size());
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(getArr(), size, a.getClass());
        }

        System.arraycopy(arr, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(E e) {
        Object[] newArr = Arrays.copyOf(getArr(), getArr().length + 1);
        newArr[getArr().length] = e;
        setArr(newArr);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = -1;
        for(int i = 0; i < getArr().length; i++)
            if(getArr()[i].equals(o))
                index = i;

        if(index == -1)
            return false;

        Object []newArr = new Object[getArr().length - 1];
        System.arraycopy(getArr(), 0, newArr, 0, index);
        System.arraycopy(getArr(), index + 1, newArr, index, newArr.length - index);
        setArr(newArr);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if(c.size() > size()){
            return false;
        }

        int count = 0;
        for(int i = 0; i < c.size(); i++){
            if(contains(c.toArray()[i]))
                count++;
        }

        if(count == c.size())
            return true;

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
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
        setArr(new Object[0]);
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) getArr()[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E obj = (E) getArr()[index];

        if(element == getArr()[index]){
            return (E) getArr()[index];
        }

        Object[] newArr = Arrays.copyOf(getArr(), getArr().length);
        newArr[index] = element;
        setArr(newArr);

        return obj;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);

        Object []newArr = new Object[getArr().length + 1];
        System.arraycopy(getArr(), 0, newArr, 0, index);
        System.arraycopy(getArr(), index, newArr, index + 1, getArr().length - index);

        newArr[index] = element;
        setArr(newArr);
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E obj = (E) getArr()[index];

        Object []newArr = new Object[getArr().length - 1];
        System.arraycopy(getArr(), 0, newArr, 0, index);
        System.arraycopy(getArr(), index + 1, newArr, index, newArr.length - index);
        setArr(newArr);
        return obj;
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
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
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
        if (index > size() || index < 0)
            throw new IndexOutOfBoundsException("Invalid index");
    }

    private class CopyOnWriteIterator implements Iterator{

        private Object[] snapshot;
        private int cursor;

        CopyOnWriteIterator(Object []elements){
            this.snapshot = elements;
        }

        @Override
        public boolean hasNext() {
            return cursor < snapshot.length;
        }

        @Override
        public Object next() {
            if (! hasNext())
                throw new NoSuchElementException();

            return  snapshot[this.cursor++];
        }
    }
}

