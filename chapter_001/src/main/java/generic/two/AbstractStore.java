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
        array.set(getId(id), model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        array.remove(getId(id));
        return true;
    }

    @Override
    public E findById(String id) {
        return array.get(getId(id));
    }

    private int getId(String s) {
        for (int i = 0; i < array.getSize(); i++) {
            if (array.get(i).getId().equals(s)) {
                return i;
            }
        }
        throw new IndexOutOfBoundsException();
    }
}
