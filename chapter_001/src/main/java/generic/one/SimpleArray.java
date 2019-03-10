package generic.one;

import java.lang.reflect.Array;
import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    private int size;
    private T[] arr;
    private int alive = 0;

    @SuppressWarnings("unchecked")
    public SimpleArray(int size, Class<T> clazz) {
        this.size = size;
        this.arr = (T[]) Array.newInstance(clazz, size);
    }

    public void add(T model) {
        if (alive >= size - 1) {
            throw new IndexOutOfBoundsException();
        }
        arr[alive++] = model;
    }

    public void set(int index, T model) {
        if (index < alive) {
            arr[index] = model;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public T get(int index) {
        if (index < alive) {
            return arr[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void remove(int index) {
        if (index < alive) {
            System.arraycopy(arr, index + 1, arr, index, alive - index - 1);
        } else {
            throw new IndexOutOfBoundsException();
        }
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
