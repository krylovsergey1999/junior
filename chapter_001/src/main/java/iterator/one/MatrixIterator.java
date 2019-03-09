package iterator.one;

import java.util.Iterator;

public class MatrixIterator implements Iterable<Integer> {
    private int[][] arr;
    private int size;

    public Iterator<Integer> iterator() {
        Iterator<Integer> it = new Iterator<Integer>() {
            private int line = 0;
            private int sizeLine = arr[line].length;
            private int column = -1;

            public boolean hasNext() {
                if ((line == size - 1) && (column == sizeLine - 1)) {
                    return false;
                }
                return true;
            }

            public Integer next() {
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException();
                }
                column++;
                if (column == sizeLine) {
                    line++;
                    sizeLine = arr[line].length;
                    column = 0;
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
