package list.six;

public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public static boolean hasCycle(Node first) {
        int maxStep = 100;
        int step = 0;
        Node elem = first.next;
        if (elem == first) {
            return false;
        }
        while (step != maxStep) {
            step++;
            elem = elem.next;
            if (elem == first) {
                return false;
            }
        }
        return true;
    }
}
