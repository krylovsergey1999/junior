package iterator.twoDimensionalArray;

import java.util.Iterator;

public class MatrixIterator implements Iterable<Integer> {
    private int[][] arr;
    private int size;

    public Iterator<Integer> iterator() {
        Iterator<Integer> it = new Iterator<Integer>() {
            private int line = 0;
            private int size_line = arr[line].length;
            private int column = -1;

            public boolean hasNext() {
                if (line < size - 1) {
                    return true;
                } else {
                    if (column < size_line - 1) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            public Integer next() {
                if (hasNext()) {
                    column++;
                    if (column == size_line) {
                        line++;
                        size_line = arr[line].length;
                        column = 0;
                    }
                } else {
                    throw new IndexOutOfBoundsException();
                }
                return arr[line][column];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    public MatrixIterator(int[][] array) {
        this.arr = array;
        this.size = arr.length;
    }
}
