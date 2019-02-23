package java.Algorithms;

import Algorithms.ReadIn;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class array {
    public static String[] reverse1(String[] a){
        String[] b = new String[a.length];
            for (int j = a.length-1,i=0; j>=0 && i<a.length;j--,i++){
                b[i] = a[j];
            }
        return b;
    }
    public static String[] reverse2(String[] a){
        for (int i=0;i<a.length/2;i++){
            String tmp = a[i];
            a[i] = a[a.length-i-1];
            a[a.length-i-1] = tmp;
        }
        return a;
    }
    public static double time(String alg,String[] a){
        Stopwatch timer = new Stopwatch();
        if (alg.equals("reverse1")) array.reverse1(a);
        if (alg.equals("reverse2")) array.reverse2(a);
        return timer.elapsedTime();
    }
    public static void main(String[] args) throws IOException {
//        Scanner s = new Scanner(System.in);
//        String str = s.nextLine();
//        String[] array = str.split("{1,}");
//        for (String a:array) System.out.print(a+" ");
        String[] c = ReadIn.read("dickens.txt");
        double t1 = time("reverse1",c);
        double t2 = time("reverse2",c);
        PrintWriter out = new PrintWriter(
                new OutputStreamWriter(
                        new FileOutputStream("reversed.txt")));
        for (String a: array.reverse1(c))
            out.print(a+" ");

        System.out.printf("%.1f and %.1f",t1,t2);
        System.out.println(out.checkError());
    }
}
