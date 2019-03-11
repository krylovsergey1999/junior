package generic.two;

import generic.one.SimpleArray;

public class UserStore implements Store<User> {
    private SimpleArray<User> arr;

    public UserStore(int size) {
        arr = new SimpleArray<>(size, User.class);
    }

    @Override
    public void add(User model) {
        arr.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        arr.set(Integer.parseInt(id), model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        arr.remove(Integer.parseInt(id));
        return true;
    }

    @Override
    public User findById(String id) {
        return arr.get(Integer.parseInt(id));
    }
}
