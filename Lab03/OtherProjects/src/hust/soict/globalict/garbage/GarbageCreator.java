package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GarbageCreator {

    public static void readFileWithoutStringBuffer() {
        try {
            String filename = "test.exe";
            byte[] inputBytes = {0};
            long startTime, endTime;
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b;
            }
            endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
        } catch (IOException ex) {
            Logger.getLogger(GarbageCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void readFileWithStringBuffer() {
        try {
            String filename = "test.exe";
            byte[] inputBytes = {0};
            long startTime, endTime;
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            StringBuilder outputStringBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                outputStringBuilder.append((char) b);
            }
            endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
        } catch (IOException ex) {
            Logger.getLogger(GarbageCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        readFileWithoutStringBuffer();
        readFileWithStringBuffer();
    }
}