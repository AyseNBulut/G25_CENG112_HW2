public class GenericQueue<T> {
    private Node<T> front;
    private Node<T> rear;

    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        if (rear != null) rear.next = node;
        rear = node;
        if (front == null) front = rear;
    }

    public T dequeue() {
        if (front == null) return null;
        T item = front.data;
        front = front.next;
        if (front == null) rear = null;
        return item;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        Node<T> current = front;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
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
}
