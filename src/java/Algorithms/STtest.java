package Algorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class STtest {
    public static void main(String[] args){
        ST<String,Integer> st = new ST<String,Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++){
//            In[] streams = new In[1];
//            streams[0] = new In(args[0]);
//            String key = streams[0].readString();
            String key = StdIn.readString();
            st.put(key,i);
        }
        for (String i: st.keys()){
            StdOut.println(i+" "+st.get(i));
        }
    }
}
