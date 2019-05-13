package tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    public final Node<E> root;
    private int nodesCount;

    public Tree(E value) {
        this.root = new Node<E>(value);
        this.nodesCount = 1;
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> parentNode = this.findBy(parent);
        boolean check = false;
        if (parentNode.isPresent()) {
            for (Node<E> el : parentNode.get().leaves()) {
                if (el.eqValue(child)) {
                    check = true;
                }
            }
            if (!check) {
                parentNode.get().add(new Node<>(child));
                nodesCount++;
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }


    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            private Queue<Node<E>> nodes = new LinkedList<>();
            private int size;
            private int step;

            {
                this.nodes.add(root);
                this.size = nodesCount;
                this.step = 0;
            }

            @Override
            public boolean hasNext() {
                return !nodes.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Can`t find element!");
                }
                Node<E> element = nodes.poll();
                for (Node<E> child : element.leaves()) {
                    nodes.offer(child);
                }
                return element.getValue();
            }
        };
        return iterator;
    }

    public int getNodesCount() {
        return nodesCount;
    }

    public boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (element != null && element.leaves().size() > 2) {
                result = false;
                break;
            }
            for (Node<E> child : element.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }
}
