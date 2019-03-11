package generic.two;

import generic.one.SimpleArray;

public class RoleStore extends AbstractStore {
    public RoleStore(int size) {
        super(new SimpleArray<>(size, Role.class));
    }
}
