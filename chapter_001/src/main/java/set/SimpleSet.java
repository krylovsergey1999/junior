package set;


import list.two.DynamicArray;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private DynamicArray<E> set;
    private int size;

    public SimpleSet(int initialCapacity) {
        this.set = new DynamicArray<>(initialCapacity);
    }

    void add(E e) {
        for (E el : set.getContainer()) {
            if (e.equals(el)) {
                return;
            }
        }
        set.add(e);
        size++;
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    public int getSize() {
        return size;
    }
}
