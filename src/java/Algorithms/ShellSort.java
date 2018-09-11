package Algorithms;

import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ShellSort {
    public static void sort(Comparable[] a) {
        int n = a.length;
        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < n/3) h = 3*h + 1;

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
//            assert isHsorted(a, h);
            h /= 3;
        }
        assert isSorted(a);
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a,int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void show(Comparable[] a){
        for(Comparable ex: a){
            StdOut.print(ex + " ");
        }
        StdOut.println();
    }
    public static boolean isSorted(Comparable[] a){
        for (int i=1;i<a.length;i++){
            if (less(a[i],a[i-1])) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
//        String[] a = StdIn.readAllStrings();
        String filename = args[0];
        String b = Files.readAllLines(Paths.get(filename)).toString().replace("[", "").replace("]", "");
        String[] a = b.split("\\s+");
        sort(a);
        show(a);
    }
}
