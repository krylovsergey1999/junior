package iterator.two;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterable<Integer> {
    private int[] arr;
    private int size;
    private int position = 0;

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> it = new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                while (position < size) {
                    if (arr[position] % 2 == 0) {
                        return true;
                    } else {
                        position++;
                    }
                }
                return false;
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    return arr[position++];
                }
                throw new NoSuchElementException();
            }
        };
        return it;
    }

    public EvenNumbersIterator(int[] array) {
        this.arr = array;
        this.size = array.length;
    }
}
