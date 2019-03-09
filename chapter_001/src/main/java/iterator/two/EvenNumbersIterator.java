package iterator.two;

import java.util.ArrayList;
import java.util.Iterator;

public class EvenNumbersIterator implements Iterable<Integer> {
    private ArrayList<Integer> list = new ArrayList<>();

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> it = list.iterator();
        return it;
    }

    public EvenNumbersIterator(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                this.list.add(array[i]);
            }
        }
    }
}
