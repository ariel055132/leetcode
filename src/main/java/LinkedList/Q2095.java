package LinkedList;

public class Q2095 {
    /**
     * 1 -> 2 -> 3 -> 4
     * (-100) -> 1 -> 2 -> 3 -> 4
     * 1 (slow) -> 2 (fast) -> 3 -> 4
     * 1 -> 2 (slow) -> 3 -> 4 (fast), fast stopped
     *
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode dummy = new ListNode(-100);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            dummy = dummy.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        dummy.next = slow.next;
        return head;
    }
}
