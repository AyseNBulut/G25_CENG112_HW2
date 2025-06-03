import java.util.*;

public class CommandProcessor {

    private GenericPriorityQueue<Ticket> queue;
    private GenericHistory<Ticket> history;
    private int arrivalCounter = 0;

    public CommandProcessor() {
        queue = new GenericPriorityQueue<>();
        history = new GenericHistory<>();
    }

    public void process(Command command) {
        switch (command.type) {
            case "new" -> {
                Ticket t = new Ticket(command.args[0], command.args[1], command.args[2], arrivalCounter++);
                System.out.println("Adding Ticket: " + t);
                queue.offer(t);
            }
            case "resolve" -> {
                Ticket resolved = queue.poll();
                if (resolved != null) {
                    System.out.println("Resolved: " + resolved);
                    history.add(resolved);
                } else {
                    System.out.println("No tickets to resolve.");
                }
            }
            case "display" -> display(command.args[0]);
            case "history" -> displayHistory(command.args.length > 0 ? command.args[0] : "name");
        }
    }

    private void display(String mode) {
        List<Ticket> all = queue.getAll(); 
        switch (mode.toLowerCase()) {
        case "priority" -> Collections.sort(all);  
        case "asc" -> all.sort(Comparator.comparingLong(Ticket::getArrivalTime));
        case "desc" -> all.sort(Comparator.comparingLong(Ticket::getArrivalTime).reversed());
    }

    System.out.println("--- Displaying Active Tickets (" + mode + ") ---");
    for (int i = 0; i < all.size(); i++) {
        System.out.println((i + 1) + ". " + all.get(i));
    }
        }

    private void displayHistory(String mode) {
        Comparator<Ticket> comparator = Comparator.comparing(Ticket::getCustomerName);
        boolean asc = mode.equals("asc") || mode.equals("name");
        history.displaySorted(comparator, asc);
    }
}
