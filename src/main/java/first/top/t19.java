package first.top;

public class t19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode cur = sentinel;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return sentinel.next;
    }

    int count = 0;

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        head.next = removeNthFromEnd2(head.next, n);
        count++;
        return count == n ? head.next : head;
    }
}
