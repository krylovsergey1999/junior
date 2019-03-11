package generic.two;

import generic.one.SimpleArray;

public class UserStore extends AbstractStore {
    public UserStore(int size) {
        super(new SimpleArray<>(size, User.class));
    }
}
