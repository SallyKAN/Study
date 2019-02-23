package Algorithms;

import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Compare {
    public static double time(String alg, Comparable[] a){
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Selection")) SelectionSort.sort(a);
        if (alg.equals("Insertion")) InsertionSort.sort(a);
        if (alg.equals("Shell")) ShellSort.sort(a);
        if (alg.equals("Merge")) MergeSort.sort(a);
        return timer.elapsedTime();
    }
    public static double timeRandomInput(String alg,int N,int T){
        double total = 0.0;
        Double[] a = new Double[N];
        for(int t=0; t<T;t++){
            for(int i=0;i<N;i++)
                a[i] = StdRandom.uniform();
            total += time(alg,a);
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
//        String filename = args[0];
//        String b = Files.readAllLines(Paths.get(filename)).toString().replace("[", "").replace("]", "");
//        String[] c = b.split("\\s+");
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1,N,T);
        double t2 = timeRandomInput(alg2,N,T);
//        double t1 = time(alg1,c); //insertion
//        double t2 = time(alg2,c); //select
//        StdOut.printf(String.valueOf(t1));
//        StdOut.printf(String.valueOf(t2));
//        StdOut.printf(String.valueOf(t2/t1));
        StdOut.printf("For %s random Double values %s is ",N,alg1);
        StdOut.printf("%.1f times faster than %s\n", t2/t1, alg2);
    }
}
