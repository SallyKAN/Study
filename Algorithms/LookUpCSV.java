package Algorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;

public class LookUpCSV {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int keyfield = Integer.parseInt(args[1]);
        int valfield = Integer.parseInt(args[2]);
        ST<String, String> st = new ST<String,String>();
        while (in.hasNextLine()){
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyfield];
            String val = tokens[valfield];
            st.put(key,val);
        }
//        In in = new In("tiny.txt");
//        HashSet<String> set = new HashSet<String>();
        while (!StdIn.isEmpty()) {
//            set.add(in.readString());
//            StdOut.print(in.readString());
            String query = StdIn.readString();
            if (st.contains(query))
                StdOut.println(st.get(query));
        }
    }
}
