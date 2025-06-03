import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "Files/example_commands.csv"; // relative path
        List<Command> commands;
    try {
        
        commands = FileIO.readCommands(filePath);
    } catch (Exception e) {
        System.err.println("Dosya okunurken bir hata oluştu: " + e.getMessage());
        return; 
    }

    CommandProcessor processor = new CommandProcessor();

    for (Command command : commands) {
        processor.process(command);
    }
}
}
