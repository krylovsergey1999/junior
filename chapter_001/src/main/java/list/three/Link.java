package list.three;

public class Link<E> {
    private E date; // данные
    public Link<E> next; // следующий элемент в списке
    public Link<E> prev; // предыдущий

    public Link(E elem) {
        this.date = elem;
    }

    public void displayLink() {
        System.out.println(date.toString());
    }

    public E getDate() {
        return date;
    }
}
