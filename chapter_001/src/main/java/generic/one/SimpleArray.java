package generic.one;

import java.lang.reflect.Array;
import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    private int size;
    private T[] arr;
    private int position = 0;
    private int alive = 0;

    @SuppressWarnings("unchecked")
    public SimpleArray(int size, Class<T> clazz) {
        this.size = size;
        this.arr = (T[]) Array.newInstance(clazz, 10);
    }

    public void add(T model) {
        if (position >= size - 1) {
            throw new IndexOutOfBoundsException();
        }
        arr[position++] = model;
        alive++;
    }

    public void set(int index, T model) {
        arr[index] = model;
    }

    public T get(int index) {
        return arr[index];
    }

    public void remove(int index) {
        for (int i = index; i < alive - 1; i++) {
            arr[i] = arr[i + 1];
        }
        alive--;
        size--;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                if (pos < alive) {
                    return true;
                }
                return false;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException();
                }
                return arr[pos++];
            }
        };
    }
}
