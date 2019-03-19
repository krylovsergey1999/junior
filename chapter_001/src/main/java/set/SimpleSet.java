package set;


import list.two.DynamicArray;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private DynamicArray<E> set;
    private int size;
    private float load;

    public SimpleSet(int initialCapacity, float loadFactor) {
        //set = new DynamicArray<>(initialCapacity,);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
