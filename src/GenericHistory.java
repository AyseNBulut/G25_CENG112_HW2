import java.util.Comparator;
import java.util.List;

public class GenericHistory<T> {
    private Node<T> head;

    public void add(T item) {
        Node<T> node = new Node<>(item);
        node.next = head;
        head = node;
    }

    public java.util.List<T> getAll() {
        java.util.List<T> list = new java.util.ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    public void display() {
        getAll().forEach(System.out::println);
    }

    public void displaySorted(Comparator<T> comparator, boolean ascending) {
    List<T> all = getAll();
    all.sort(ascending ? comparator : comparator.reversed());
    for (int i = 0; i < all.size(); i++) {
    System.out.println((i + 1) + ". " + all.get(i));
    }
    }
}