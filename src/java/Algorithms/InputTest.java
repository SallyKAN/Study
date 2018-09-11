package Algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InputTest {
    public static void main(String[] args) {
    while (!StdIn.isEmpty()) {
        String line = StdIn.readString();
        StdOut.println(line);
    }
    }
}
