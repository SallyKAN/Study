package Algorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LookUpCSV2 {
        // Do not instantiate.
        private LookUpCSV2() { }
        public static void main(String[] args) {
            int keyField = Integer.parseInt(args[1]);
            int valField = Integer.parseInt(args[2]);

            // symbol table
            ST<String, String> st = new ST<String, String>();

            // read in the data from csv file
            In in = new In(args[0]);
            while (in.hasNextLine()) {
                String line = in.readLine();
                String[] tokens = line.split(",");
                String key = tokens[keyField];
                String val = tokens[valField];
                st.put(key, val);
            }

            while (!StdIn.isEmpty()) {
                String s = StdIn.readString();
                if (st.contains(s)) StdOut.println(st.get(s));
                else                StdOut.println("Not found");
            }
        }
    }


