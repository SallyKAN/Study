public class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA;
        ListNode second = headB;
        while (first != second) {
            first= first==null ? first.next : headB;
            second = second==null ? second.next : headA;
        }
        return first;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}