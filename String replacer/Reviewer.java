import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class NumberFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        // Read the contents of the file into a list
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("D:\\Java\\Numbers.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(lines == null) return;
        List<Integer> numbers = new ArrayList<>();
        for(String line: lines) {
            numbers.add(Integer.parseInt(line));
        }

        // Check if the given number is in the list
        if (numbers.contains(num)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }
}
