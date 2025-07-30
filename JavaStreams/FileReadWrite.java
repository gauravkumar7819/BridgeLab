import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {
            
            int content;
            while ((content = fis.read()) != -1) {
                fos.write(content);
            }
            System.out.println("File copied successfully!");
            
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error during file operations: " + e.getMessage());
        }
    }
}