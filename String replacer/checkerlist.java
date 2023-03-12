import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class StringReplacer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the contents of the file into a list
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("D:\\Java\\Names.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(lines == null) return;

        System.out.print("Enter a string to replace: ");
        String oldString = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).equals(oldString)) {
                System.out.print("Enter a replacement string: ");
                String newString = scanner.nextLine();
                lines.set(i, newString);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Invalid text");
        } else {
            // write the modified content to the file
            Path filePath = Paths.get("D:\\Java\\Names.txt");
            try {
                Files.write(filePath, lines);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("New set of strings:");
            for (String line : lines) {
                System.out.println(line);
            }
        }
    }
}
