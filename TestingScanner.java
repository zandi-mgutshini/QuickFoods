import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestingScanner {
    public static void main(String[] args) {
        try {
            File text = new File("/Users/zmgutshini/IdeaProjects/CapstoneProject/src/numbers.txt");
            Scanner scanner = new Scanner(text);
            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("line " + lineNumber + ": " + line);
                lineNumber++;
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }
}
