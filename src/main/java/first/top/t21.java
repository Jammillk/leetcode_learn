package first.top;

public class t21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        } else if (l2 == null){
            cur.next = l1;
        }
        return sentinel.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists2(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists2(l1, l2.next);
                return l2;
            }
        }
    }
}
