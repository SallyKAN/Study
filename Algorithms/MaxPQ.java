package Algorithms;

import java.security.Key;

public class MaxPQ {
    private Key[] pq;
    private int N = 0;
    public MaxPQ(int N){
        pq = (Key[])new Comparable[N+1];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int Size(){
        return N;
    }
    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }
    public Key delMax(){
        Key max = pq[1];
        exch(1,N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private void exch(int i, int j){
        Key t =pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    public void swim(int k){
        while (k>1&&less(k/2,k)){
            exch(k/2,k);
            k = k/2;
        }
    }
    public void sink(int k){
        while (2*k <= N){
            int j=2*k;
            if (j<N && less(j,j+1)) j++;
            if (!less(k,j)) break;
            exch(k,j);
            k = j;
        }
    }

}
