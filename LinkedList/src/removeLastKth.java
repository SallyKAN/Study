public class removeLastKth {
    public static Node removeLastKth(Node head, int k) {
        if (head == null || k < 0) {
            return null;
        }
        Node cur = head;
        while (cur.next != null) {
            k--;
            cur = cur.next;
        }
        if (k == 0) {
            head = head.next;
        }
        if (k < 0) {
            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        Node cur = node1;
//        while (cur.next != null){
//            System.out.println(cur.data);
//            cur = cur.next;
//        }
        removeLastKth(cur,2);
        while (cur.next != null){
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
}

