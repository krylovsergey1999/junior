package list.four;

import list.three.LinkList;

public class SimpleStack<T> {
    private LinkList<T> stack;

    public SimpleStack() {
        this.stack = new LinkList<>();
    }

    public T poll() {
        return stack.deleteFirst();
    }

    public void push(T value) {
        stack.insertFirst(value);
    }
}
