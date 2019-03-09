package iterator.three;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> iter = it.next();

            @Override
            public boolean hasNext() {
                while (true) {
                    if (iter.hasNext()) {
                        return true;
                    } else {
                        if (it.hasNext()) {
                            iter = it.next();
                        } else {
                            return false;
                        }
                    }
                }
            }

            @Override
            public Integer next() {
                if (iter.hasNext()) {
                    return iter.next();
                }
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
                iter = it.next();
                return iter.next();
            }
        };
    }
}
