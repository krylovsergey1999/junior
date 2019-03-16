package list.three;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class LinkList<E> implements Iterable<Link<E>> {
    private int modCount = 0;

    private Link<E> first; // ссылка на первый элемент списка

    public LinkList() {
        first = null; // список пока пуст
    }

    public boolean isEmpry() {
        return (first == null);
    }

    // вставка элемента в начало списка
    public void insertFirst(E elem) {
        modCount++;
        Link<E> newLink = new Link(elem);
        newLink.next = first;
        newLink.prev = null;
        if (first != null) {
            first.prev = newLink;
        }
        first = newLink;
    }

    // получение элемента
    public E get(int index) {
        Link<E> current = first;
        int number = 1;
        while (current != null) {
            current = current.next;
            number++;
            if (number == index) {
                return current.getDate();
            }
        }
        throw new IndexOutOfBoundsException("Такого элемента нет.");
    }

    // удаление первого элемента
    public Link<E> deleteFirst() {
        modCount++;
        Link<E> temp = first;
        first = first.next;
        first.prev = null;
        return temp;
    }

    // вывод всего списка
    public void displayList() {
        System.out.println("List (first --> last");
        Link<E> current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    @Override
    public Iterator<Link<E>> iterator() {
        return new Iterator<Link<E>>() {
            Link<E> current = first;
            private int check = modCount;

            @Override
            public boolean hasNext() {
                if (check != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (current != null) {
                    return true;
                }
                return false;
            }

            @Override
            public Link<E> next() {
                if (check != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (current != null) {
                    Link<E> temp = current;
                    current = current.next;
                    return temp;
                }
                return null;
            }
        };
    }
}
