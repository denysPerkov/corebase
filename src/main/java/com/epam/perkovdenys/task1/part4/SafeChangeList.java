package com.epam.perkovdenys.task1.part4;
import java.util.*;

public class SafeChangeList<E> implements List<E> {

    private List<E> unmodifiable;
    private List<E> modifiable;

    public SafeChangeList(){
        this.modifiable = new ArrayList<>();
    }

    public SafeChangeList(List<E> list){
        this.unmodifiable = new ArrayList<>(list);
        //this.unmodifiable = Collections.unmodifiableList(unmodifiable);
        this.modifiable   = new ArrayList<>();
    }

    @Override
    public int size() {
        return unmodifiable.size() + modifiable.size();
    }

    @Override
    public boolean isEmpty() {
        return (unmodifiable.isEmpty() && modifiable.isEmpty())? true : false;
    }

    @Override
    public boolean contains(Object o) {
        return (unmodifiable.contains(o) || modifiable.contains(o))? true : false;
    }

    @Override
    public Iterator<E> iterator() {
        return new ConsolidateIterator();
    }


    @Override
    public Object[] toArray() {
        int size = modifiable.size() + unmodifiable.size();
        Object []arr = new Object[size];

        System.arraycopy(unmodifiable.toArray(), 0, arr, 0, unmodifiable.size());
        System.arraycopy(modifiable.toArray(), 0, arr, unmodifiable.size(), modifiable.size());

        return arr;
    }


    @Override
    public <T> T[] toArray(T[] a) {
        int size = modifiable.size() + unmodifiable.size();
        a = (T[]) new Object[size];

        System.arraycopy(unmodifiable.toArray(), 0, a, 0, unmodifiable.size());
        System.arraycopy(modifiable.toArray(), 0, a, unmodifiable.size(), modifiable.size());

        return a;
    }

    @Override
    public boolean add(E e) {
        return modifiable.add(e);
    }

    @Override
    public boolean remove(Object o) {
        if( unmodifiable.contains(o) && (!modifiable.contains(o)) ) {
            throw new UnsupportedOperationException();
        }

        return modifiable.remove(o);
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object it : c) {
            if (!(modifiable.contains(it) || unmodifiable.contains(it))){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return modifiable.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        checkModifiableIndex(index);

        return modifiable.addAll(index - unmodifiable.size(), c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object it : c)
            if(unmodifiable.contains(it) && (!modifiable.contains(it)))
                throw new UnsupportedOperationException();

        return modifiable.removeAll(c);
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        return modifiable.retainAll(c);
    }

    // Clean only changeable part
    @Override
    public void clear() {
      modifiable.clear();
    }

    @Override
    public E get(int index) {
        checkIndex(index);

        if(index < unmodifiable.size()) {
            return unmodifiable.get(index);
        }else{
            return modifiable.get(index - unmodifiable.size());
        }
    }

    @Override
    public E set(int index, E element) {
        checkModifiableIndex(index);
        modifiable.set(index - unmodifiable.size(), element);

        return element;
    }

    @Override
    public void add(int index, E element) {
        checkModifiableIndex(index);
        modifiable.add(index - unmodifiable.size(), element);
    }

    @Override
    public E remove(int index) {
        checkModifiableIndex(index);
        E obj = modifiable.get(index - unmodifiable.size());
        modifiable.remove(index - unmodifiable.size());

        return obj;
    }

    @Override
    public int indexOf(Object o) {

        if(unmodifiable.indexOf(o) >= 0) {
            return unmodifiable.indexOf(o);
        }else{
            return modifiable.indexOf(o) + unmodifiable.size();
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        if(unmodifiable.lastIndexOf(o) >= 0) {
            return unmodifiable.lastIndexOf(o);
        }else{
            return modifiable.lastIndexOf(o) + unmodifiable.size();
        }
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

    private void checkIndex(int index) {
        if (index > (modifiable.size() + unmodifiable.size()) || index < 0)
            throw new IndexOutOfBoundsException("Invalid index");
    }

    private void checkModifiableIndex(int index) {
        if( (index < 0) || (index < unmodifiable.size()) || (index > (unmodifiable.size() + modifiable.size())) )
            throw new UnsupportedOperationException("Invalid index");
    }

    private class ConsolidateIterator implements Iterator{

        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < (unmodifiable.size() + modifiable.size());
        }

        @Override
        public Object next() {
            if (! hasNext())
                throw new NoSuchElementException();

            if(this.cursor < unmodifiable.size())
                return unmodifiable.get(cursor++);
            else{
                Object o = modifiable.get(cursor - unmodifiable.size());
                cursor++;
                return o;
            }

        }
    }
}
