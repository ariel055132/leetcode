package LinkedList;

public class Q83 {
    public ListNode deleteDuplicates(ListNode head) {
        // If head is null, just return head (aka. null)
        if (head == null) {
            return head;
        }
        ListNode dummy = head;
        // Traverse the linked list
        while (dummy.next != null) {
            // If face duplicated number, jump to the next element
            if (dummy.next.val == dummy.val) {
                dummy.next = dummy.next.next;
            } else {
                dummy = dummy.next;
            }
        }
        return head;
    }
}
