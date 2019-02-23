package Algorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
    public static void sort(Comparable[] a,int lo,int hi){
        if (lo >= hi) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j);
        sort(a,j+1,hi);
    }
    public static int partition(Comparable[] a, int lo,int hi){
        int i=lo,j=hi+1;
        Comparable v=a[lo];
        while (true){
            while (less(a[++i],v)) if (i==hi) break;
            while (less(v,a[--j])) if (j==lo) break;
            if (i>=j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
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
    public static void main(String[] args){
        Comparable[] a = new Comparable[]{2,1,4,3,8,5,6,0,9};
//        sort(a);
        partition(a,0,a.length-1);
        show(a);

    }


}
