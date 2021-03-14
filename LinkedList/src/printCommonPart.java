public class printCommonPart {
    class Node{
        public int data;
        public Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public void printCommonPart(Node first,Node secod){
        if (first == null || secod == null){
            return;
        }
        if (first.data < secod.data){
            first = first.next;
        }else if (secod.data < first.data){
            secod = secod.next;
        }else {
            System.out.println(first.data+" ");
            first = first.next;
            secod = secod.next;
        }
        System.out.println();
    }


}




