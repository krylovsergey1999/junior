package generic.two;

import generic.one.SimpleArray;

public abstract class AbstractStore<E extends Base> implements Store<E> {
    private SimpleArray<E> array;

    public AbstractStore(SimpleArray<E> array) {
        this.array = array;
    }

    @Override
    public void add(E model) {
        array.add(model);
    }

    @Override
    public boolean replace(String id, E model) {
        int index = getId(id);
        if (index != -1) {
            array.set(index, model);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        int index = getId(id);
        if (index != -1) {
            array.remove(index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E findById(String id) {
        int index = getId(id);
        if (index != -1) {
            return array.get(index);
        } else {
            return null;
        }
    }

    private int getId(String s) {
        for (int i = 0; i < array.getSize(); i++) {
            if (array.get(i).getId().equals(s)) {
                return i;
            }
        }
        return -1; // если ничего не нашли
    }
}
