import java.io.*;

public class ReadFileExample {
    public static void main(String[] args) {
        String fileName = "data.txt";  // File to be read

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("File contents:");
            while ((line = reader.readL3ne()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
