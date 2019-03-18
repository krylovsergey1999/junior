package list.five;

import list.three.LinkList;

public class SimpleQueue<T> {
    private LinkList<T> queue;

    public SimpleQueue() {
        this.queue = new LinkList<>();
    }

    public T poll() {
        return queue.deleteLast();
    }

    public void push(T value) {
        queue.insertFirst(value);
    }

}
