package Algorithms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadIn {
    public static String[] read(String name) throws IOException {
        String filename = name;
        String b = Files.readAllLines(Paths.get(filename)).toString().replace("[", "").replace("]", "");
        String[] a = b.split("\\s+");
        return a;
    }
}
