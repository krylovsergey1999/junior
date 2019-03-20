package set;


import list.two.DynamicArray;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private DynamicArray<E> set;
    private int size = 0;

    public SimpleSet(int length) {
        this.set = new DynamicArray<>(length);
    }

    void add(E e) {
        E[] arr = set.getContainer();
        if (e == null) {
            for (int i = 0; i < size; i++) {
                if (arr[i] == null) {
                    return;
                }
            }
            set.setPosition(set.getPosition() + 1);
            size++;
        } else {
            for (int i = 0; i < size; i++) {
                if (e.equals(arr[i])) {
                    return;
                }
            }
            set.add(e);
            size++;
        }
    }

    public void see() {
        for (E el : set.getContainer()) {
            System.out.println(el);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    public int getSize() {
        return size;
    }
}
