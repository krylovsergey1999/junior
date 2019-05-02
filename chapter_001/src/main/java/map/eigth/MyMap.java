package map.eigth;

import java.util.*;

/**
 * @Author Krylov Sergey
 */
public class MyMap<K, V> implements Iterable<MyMap.Entry<K, V>> {
    private int length = 16;
    private float loadfactor = (float) 0.75;
    private int size = 0;
    private Entry<K, V>[] map = new Entry[length];

    public boolean insert(K key, V value) {
        int h = hash(key);
        if (map[h] == null) {
            map[h] = new Entry<K, V>(key, value);
            size++;
            if ((double) size / (double) length >= loadfactor) {
                expansion();
            }
            return true;
        } else {
            if (map[h].getKey().equals(key)) {
                map[h].setValue(value);
                return true;
            }
            return false;
        }
    }

    public V get(K key) {
        int h = hash(key);
        if (map[h] != null) {
            return map[h].getValue();
        }
        return null;
    }

    public boolean delete(K key) {
        int h = hash(key);
        if (map[h] != null) {
            map[h] = null;
            size--;
            return true;
        } else {
            return false;
        }
    }

    public boolean expansion() {
        this.length *= 2;
        Entry<K, V>[] mapNew = new Entry[length];
        int sizeNew = 0;
        for (int i = 0; i < this.map.length; i++) {
            if (map[i] != null) {
                K key = map[i].getKey();
                int h = hash(key);
                if (mapNew[h] == null) {
                    mapNew[h] = map[i];
                    sizeNew++;
                }
            }
        }
        setMap(mapNew);
        setSize(sizeNew);
        return true;
    }

    public void print() {
        for (Entry<K, V> el : map) {
            System.out.print("Ячейка: ");
            if (el != null) {
                System.out.print("{" + el.getKey() + " - " + el.getValue() + "}");
            }
            System.out.println();
        }
    }

    public int hash(Object object) {
        int h = object.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        h = h ^ (h >>> 7) ^ (h >>> 4);
        return h % length;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {
            public int passed = 0;
            private int step = 0;

            @Override
            public boolean hasNext() {
                return passed < size;
            }

            @Override
            public Entry<K, V> next() {
                if (hasNext()) {
                    while (map[step] == null) {
                        step++;
                    }
                    passed++;
                    return map[step++];
                }
                throw new NoSuchElementException("Итератор не нашел следующего элемента");
            }
        };
    }

    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Entry<K, V>[] getMap() {
        return map;
    }

    public void setMap(Entry<K, V>[] map) {
        this.map = map;
    }
}
