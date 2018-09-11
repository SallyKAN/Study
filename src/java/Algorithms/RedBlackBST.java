package Algorithms;

import java.io.IOException;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private static final boolean RED   = true;
    private static final boolean BLACK = false;
    private class Node {
        private Key key;           // key
        private Value val;         // associated data
        private Node left, right;  // links to left and right subtrees
        private boolean color;     // color of parent link
        private int size;          // subtree count

        public Node(Key key, Value val, boolean color, int size) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }
    }

    private boolean isRed(Node node){
        if (node == null) return false;
        return node.color == RED;
    }
    public int size() {
        return size(root);
    }
    private int size(Node x) {
        if (x == null) return 0;
        return x.size;
    }
    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color =RED;
        x.size = h.size;
        h.size = 1+ size(h.left)+size(h.right);
        return x;
    }
    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        return x;
    }
    private void filpColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    public void put(Key key, Value value){
        root = put(root,key,value);
        root.color = BLACK;
    }
    private Node put(Node h, Key key, Value value){
        if (h == null)
            return new Node(key, value,RED,1);
        int cmp = key.compareTo(h.key);
        if(cmp<0) h.left = put(h.left,key,value);
        else if(cmp>0) h.right = put(h.right,key,value);
        else h.val = value;
        if(isRed(h.right) && !isRed(h.left)) h=rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left)) h=rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) filpColors(h);
        h.size = size(h.left) +size(h.right) +1;
        return h;
    }
    public static void main(String[] args) throws IOException {
        String[] a = ReadIn.read(args[0]);
        RedBlackBST<String,Integer> example = new RedBlackBST<>();
        int i = 0;
        for (String s: a){
            example.put(s,++i);
        }
        System.out.println(example);
    }
}
