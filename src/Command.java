import java.util.Arrays;

public class Command {
    String type;
    String customerName;
    String issue;
    String priority;
    public String[] args;

    public Command(String[] parts) {
       
       type = parts[0].trim().toLowerCase();
    if (type.equals("new")) {
        customerName = parts[1].trim();
        issue = parts[2].trim();
        priority = parts[3].trim();
    } else if (type.equals("display") || type.equals("history")) {
        if (parts.length > 1) {
            customerName = parts[1].trim(); 
        }
    }
     this.args = parts.length > 1 ? Arrays.copyOfRange(parts, 1, parts.length) : new String[0];
}
}