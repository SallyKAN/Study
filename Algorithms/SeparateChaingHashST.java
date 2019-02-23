package Algorithms;

import edu.princeton.cs.algs4.SequentialSearchST;

import java.util.TreeMap;

public class SeparateChaingHashST<Key,Value> {
    private int N;
    private int M;
    private SequentialSearchST<Key,Value>[] st;
    public SeparateChaingHashST(){
        this(997);
    }
    public SeparateChaingHashST(int M){
        this.M = M;
        st = (SequentialSearchST<Key,Value>[]) new SequentialSearchST[M];
        for (int i=0;i<M;i++){
            st[i] = new SequentialSearchST();
        }
    }
    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff)% M;
    }
    public Value get(Key key){
        return (Value)(st[hash(key)].get(key));
    }
    public void put(Key key, Value value){
        st[hash(key)].put(key,value);
    }
    public void resize(int cap){
        SeparateChaingHashST<Key,Value> t = new SeparateChaingHashST<Key,Value>(cap);

    }
}
