package Algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

import static edu.princeton.cs.algs4.StdIn.isEmpty;

public class BinarySearch<Key extends Comparable<Key>,Value> {
    private Key[] keys;
    private Value[] values;
    private int N;
    public BinarySearch(int N){
        keys = (Key[])new Comparable[N];
        values = (Value[])new Object[N];
    }
    public int size(){
        return N;
    }
    public Value get(Key key){
        if (isEmpty()) return null;
        int i = rank(key);
        if(i<N && keys[i].compareTo(key)== 0) return values[i];
        else return null;
    }
    public int rank(Key key){
        int lo = 0, hi = N-1;
        while (lo<= hi){
            int mid = lo+hi-lo/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp<0) hi = mid-1;
            else if (cmp>0) lo = mid+1;
            else return mid;
        }
        return lo;
    }
    public void put(Key key, Value value){
        int i = rank(key);
        if(i < N && key.compareTo(keys[i]) == 0){
            values[i] = value; return;
        }
        for (int j = N; j>i; j--){
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;

    }
//    public void delete(Key key){
//        keys[i] = key;
//    }
    public void add(Key key, Value value){
        keys[N] = key;
        values[N] = value;
        N++;
    }

    public static void main(String[] args){
        BinarySearch bs = new BinarySearch(11);
        bs.add("A+",4.33);
        bs.add("A",4.00);
        bs.add("A-",3.67);
        bs.add("B+",3.33);
        bs.add("B",3.00);
        bs.add("B-",2.67);
        bs.add("C+",2.33);
        bs.add("C",2.00);
        bs.add("C-",1.67);
        bs.add("D",1.00);
        bs.add("F",0.00);
        Scanner in = new Scanner(System.in);
        System.out.println("How many grades do you want to enter?");
        int num = in.nextInt();
        String[] str = new String[num];
        System.out.println("Enter the " + num + " grades now.");
        for (int i = 0 ; i < str.length; i++ ) {
            str[i] = in.next();
        }
//        for (String s: str){
//            System.out.println(s);
//        }
        double sum = 0;
        for (String s: str){
            sum += (double)bs.get(s);
        }
        double avg = sum/num;
        System.out.println(avg);
//        String str = StdIn.readString();
//        System.out.print(str);


    }


}
