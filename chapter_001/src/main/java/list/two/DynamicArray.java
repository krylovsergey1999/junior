package list.two;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<E> implements Iterable<E> {
    private E[] container;
    private int position = 0;
    private int size;
    private int modCount = 0;

    @SuppressWarnings("unchecked")
    public DynamicArray(int size) {
        this.size = size;
        this.container = (E[]) new Object[size];
    }

    public void add(E value) {
        if (position < size) {
            this.container[position++] = value;
        } else {
            extension(value);
        }
        this.modCount++;
    }

    private void extension(E x) {
        this.container = Arrays.copyOf(container, size * 2);
        size = size * 2;
        this.container[position++] = x;
    }

    public E get(int index) {
        if (index < position) {
            return container[index];
        } else {
            return null;
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int mod = modCount;
            private int pos = 0;

            @Override
            public boolean hasNext() {
                if (mod != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (this.pos < position) {
                    return true;
                }
                return false;
            }

            @Override
            public E next() {
                if (mod != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[pos++];
            }
        };
    }

    public E[] getContainer() {
        return container;
    }
}
