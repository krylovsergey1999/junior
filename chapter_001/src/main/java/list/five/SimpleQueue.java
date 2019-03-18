package list.five;

import list.four.SimpleStack;
import list.three.LinkList;

public class SimpleQueue<T> {
    private SimpleStack<T> leftStack;
    private SimpleStack<T> rightStack;

    public SimpleQueue() {
        this.leftStack = new SimpleStack<>();
        this.rightStack = new SimpleStack<>();
    }

    public void push(T el) {
        leftStack.push(el);
    }

    public T poll() {
        if (!rightStack.isEmpty()) {
            return rightStack.poll();
        } else {
            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.poll());
            }
            return rightStack.poll();
        }
    }
}
