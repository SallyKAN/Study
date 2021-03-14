public class removeMiddle {
    public static Node removeMiddle(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null && head.next != null) {
           return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null){
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
