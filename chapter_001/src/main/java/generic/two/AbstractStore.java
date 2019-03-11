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
        array.set(Integer.parseInt(id), model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        array.remove(Integer.parseInt(id));
        return true;
    }

    @Override
    public E findById(String id) {
        return array.get(Integer.parseInt(id));
    }
}
