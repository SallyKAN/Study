package Algorithms;

import edu.princeton.cs.algs4.*;

public class TopM {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<Transaction>(N + 1);
        while (StdIn.hasNextLine()) {
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size() > N)
                pq.delMin();
            Stack<Transaction> stack = new Stack<Transaction>();
            while (pq.isEmpty()) stack.push(pq.delMin());
            for (Transaction t : stack) StdOut.println(t);
//        int i = 0;
//        int a = 0;
//        int b = i++;
//        int c = ++a;
//        System.out.println(b);
//        System.out.println(c);
        }
    }
}

