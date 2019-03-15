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

    public DynamicArray(int size, Class<E> clazz) {
        this.size = size;
        this.container = (E[]) Array.newInstance(clazz, size);
    }

    public void add(E value) {
        if (position < size) {
            this.container[position++] = value;
        } else {
            this.container = Arrays.copyOf(container, size * 2);
            size = size * 2;
            this.container[position++] = value;
        }
        this.modCount++;
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
                if (this.pos < position - 1) {
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
}
