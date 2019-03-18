package list.six;

public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public static boolean hasCycle(Node first) {
        if (first == null)
            return false;
        Node agentA = first;
        Node agentB = first.next;
        while (true) {
            if (agentA == agentB) {
                return true;
            }
            if (agentA == null || agentB == null || agentB.next == null) {
                return false;
            }
            agentA = agentA.next;
            agentB = agentB.next.next;
        }
    }
}
