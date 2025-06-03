public class GenericPriorityQueue<T extends Comparable<T>> {

    private GenericQueue<T> high;
    private GenericQueue<T> medium;
    private GenericQueue<T> low;

    public GenericPriorityQueue() {
        high = new GenericQueue<>();
        medium = new GenericQueue<>();
        low = new GenericQueue<>();
    }

    public void offer(T item) {
    if (item instanceof Ticket) {
    String p = ((Ticket) item).getPriority().toLowerCase();
    if (p.equals("high")) {
    high.enqueue(item);
    } else if (p.equals("medium")) {
    medium.enqueue(item);
    } else {
    low.enqueue(item); 
    }
    } else {
    
    low.enqueue(item);
    }
    }

    public T poll() {
        if (!high.isEmpty()) return high.dequeue();
        else if (!medium.isEmpty()) return medium.dequeue();
        else if (!low.isEmpty()) return low.dequeue();
        return null;
    }

    public boolean isEmpty() {
        return high.isEmpty() && medium.isEmpty() && low.isEmpty();
    }

    public java.util.List<T> getAll() {
        java.util.List<T> all = new java.util.ArrayList<>();
        all.addAll(high.getAll());
        all.addAll(medium.getAll());
        all.addAll(low.getAll());
        return all;
    }
}
