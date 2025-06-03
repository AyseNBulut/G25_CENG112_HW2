import java.io.*;
import java.util.*;

public class FileIO {
    public static List<Command> readCommands(String filename) throws IOException {
        List<Command> commands = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                String[] parts = line.split(",");
                for (int i = 0; i < parts.length; i++) parts[i] = parts[i].trim();
                commands.add(new Command(parts));
            }
        }
        reader.close();
        return commands;
    }
}