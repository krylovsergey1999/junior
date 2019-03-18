package list.four;

import list.three.LinkList;

public class SimpleStack<T> {
    private LinkList<T> stack;

    public SimpleStack() {
        this.stack = new LinkList<>();
    }

    public T poll() {
        T value = stack.get(1);
        stack.deleteFirst();
        return value;
    }

    public void push(T value) {
        stack.insertFirst(value);
    }
}
