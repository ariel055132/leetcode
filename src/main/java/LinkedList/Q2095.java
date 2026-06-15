package LinkedList;

public class Q2095 {
    /**
     * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
     * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
     * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
     * 
     * Algorithm:
     * Use slow and fast pointers and traverse the array.
     * When fast pointer reaches the end, slow is at the middle node. (Just skip slow)
     * Therefore, also need a pointer to the node before slow, so that we can skip the middle node
     * 
     * Example as follows:
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
