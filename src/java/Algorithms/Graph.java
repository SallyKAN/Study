package Algorithms;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;
//    public Graph(int V){
//        this.V = V;
//        this.E = 0;
//        adj = (Bag<Integer>[]) new Bag[V];
//        for (int v=0; v<V;v++)
//            adj[v] = new Bag<Integer>();
//    }
    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v=0; v<V;v++)
            adj[v] = new Bag<Integer>();
    }
    public Graph(In in){
        this(in.readInt());
        int E = in.readInt();
        for (int e=0;e<E;e++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }
    public int V(){ return V;}
    public int E(){return E;}
    public void addEdge(int v, int w){
//        if(adj[v] == null) adj[v] = new Bag<Integer>();
//        if(adj[w] == null) adj[w] = new Bag<Integer>();
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    public static void main(String[] args){
        Graph g = new Graph(new In(args[0]));
//        System.out.println(g.v1);
//        System.out.println();
        int s = Integer.parseInt(args[1]);
//        Search search = new Search(g,s);
        for(int v=0; v<g.V();v++){
//            if (search.marked(v))
                StdOut.print(v + " ");
            StdOut.println();
//            if (search.count()!= g.V())
                StdOut.print("Not ");
            StdOut.println("connedcted");
        }
    }
}
//class Search()
