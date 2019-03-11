package generic.two;

import generic.one.SimpleArray;

public class RoleStore implements Store<Role> {
    private SimpleArray<Role> arr;

    public RoleStore(int size) {
        arr = new SimpleArray<>(size, Role.class);
    }

    @Override
    public void add(Role model) {
        arr.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        arr.set(Integer.parseInt(id), model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        arr.remove(Integer.parseInt(id));
        return true;
    }

    @Override
    public Role findById(String id) {
        return arr.get(Integer.parseInt(id));
    }
}
