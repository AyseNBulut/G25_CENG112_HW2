public class GenericDeque<T> {
    private Node<T> front;
    private Node<T> rear;

    public void addFront(T item) {
        Node<T> node = new Node<>(item);
        if (front == null) rear = node;
        else node.next = front;
        front = node;
    }

    public void addBack(T item) {
        Node<T> node = new Node<>(item);
        if (rear == null) front = node;
        else rear.next = node;
        rear = node;
    }

    public T removeFront() {
        if (front == null) return null;
        T item = front.data;
        front = front.next;
        if (front == null) rear = null;
        return item;
    }

    public T removeBack() {
        if (rear == null) return null;
        if (front == rear) {
            T item = rear.data;
            front = rear = null;
            return item;
        }
        Node<T> current = front;
        while (current.next != rear) current = current.next;
        T item = rear.data;
        current.next = null;
        rear = current;
        return item;
    }

    public java.util.List<T> getAll() {
        java.util.List<T> list = new java.util.ArrayList<>();
        Node<T> current = front;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    public void display() {
        for (T item : getAll()) {
            System.out.println(item);
        }
    }
}