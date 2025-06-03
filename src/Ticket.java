import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    private String customerName;
    private String issueDescription;
    private String priority;
    private long arrivalTime;

    public Ticket(String customerName, String issueDescription, String priority, long arrivalTime) {
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public String getPriority() {
        return priority;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public int compareTo(Ticket other) {
    int p1 = getPriorityValue(this.priority);
    int p2 = getPriorityValue(other.priority);
    if (p1 != p2) {
    return Integer.compare(p2, p1); // higher priority first
    }
    return Long.compare(this.arrivalTime, other.arrivalTime);}


    @Override
    public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Ticket ticket = (Ticket) obj;
    return arrivalTime == ticket.arrivalTime &&
    Objects.equals(customerName, ticket.customerName) &&
    Objects.equals(issueDescription, ticket.issueDescription) &&
    Objects.equals(priority, ticket.priority);
    }

    @Override
    public int hashCode() {
    return Objects.hash(customerName, issueDescription, priority, arrivalTime);
    }

    private int getPriorityValue(String p) {
        switch (p.toLowerCase()) {
            case "high": return 3;
            case "medium": return 2;
            case "low": return 1;
            default: return 0;
        }
    }

    @Override
    public String toString() {
        return customerName + ", " + issueDescription + ", " + priority + ", " + arrivalTime;
    }
}