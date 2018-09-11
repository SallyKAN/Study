package Algorithms;

import edu.princeton.cs.algs4.StdOut;
import org.omg.CORBA.PRIVATE_MEMBER;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node{
        private Key key;
        private Value value;
        private Node left,right;
        private int N;
        public Node(Key key, Value value, int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }

    }
    public int size(){
        return size(root);
    }
    public int size(Node x){
        if(x == null) return 0;
        else return x.N;
    }
    public Value get(Key key){
        return get(root, key);

    }
    private Value get(Node x, Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) get(x.left, key);
        else if (cmp > 0) get(x.right, key);
        return x.value;
    }
    public void put(Key key, Value value){
        root = put(root, key,value);
    }
    private Node put(Node x, Key key, Value value){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) put(x.left, key, value);
        else if (cmp > 0) put(x.right, key,value);
        else x.value = value;
        x.N = size(x.left)+size(x.right) + 1;
        return x;
    }
    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){
        if (x.left == null) return x;
        return min(x.left);
    }
    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        if(x.right == null) return x;
        return max(x.right);
    }
    public Key floor(Key key){
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }
    private Node floor(Node x, Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (x != null) return t;
        else  return x;
    }
    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node x){
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void delete(Key key){
        root = delete(root,key);
    }
    private Node delete(Node x, Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0 ) x.left = delete(x.left, key);
        else if (cmp > 0 ) x.right = delete(x.right, key);
        else {
            if(x.left == null) return x.right;
            if (x.right == null) return x.left;
            Node t= x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;

    }
    private void print(Node x){
        if (x == null) return;
        print(x.left);
        StdOut.println(x.key);
        print(x.right);
    }
    public static void main(String[] args){
        BST bst = new BST();
        bst.put("E",1);
        bst.put("A",2);
        bst.put("S",3);
        bst.put("Y",4);
        bst.put("Q",5);
        bst.put("U",6);
        bst.put("E",7);
        bst.put("S",8);
        bst.put("T",9);
        bst.put("I",10);
        bst.put("O",11);
        bst.put("N",12);
//        bst.print(Node);
    }

}
