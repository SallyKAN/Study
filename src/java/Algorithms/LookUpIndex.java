package Algorithms;

import edu.princeton.cs.algs4.*;

//import java.util.Queue;

public class LookUpIndex {
    public static void main(String[] args) {
        In in = new In(args[0]);
        ST<String, Queue<String>> st = new ST<String, Queue<String>>();
        ST<String, Queue<String>> ts = new ST<String, Queue<String>>();
        while (in.hasNextLine()){
            String line = in.readLine();
            String[] words = line.split(",");
            String key = words[0];
            for (int i=1; i<words.length;i++){
                String val = words[i];
                if (!st.contains(key)) st.put(key,new Queue<String>());
                if (!ts.contains(val))ts.put(val,new Queue<String>());
                st.get(key).enqueue(val);
                ts.get(val).enqueue(key);
            }
        }
        while (!StdIn.isEmpty()){
            String query = StdIn.readLine();
            if (st.contains(query))
                for (String s:st.get(query))
                    StdOut.println("" + s);
            if (ts.contains(query))
                for (String s: ts.get(query))
                    StdOut.println(" "+ s);
        }
    }
}
