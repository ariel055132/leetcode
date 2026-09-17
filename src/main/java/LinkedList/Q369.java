package LinkedList;


public class Q369 {
    /**
     * 
     * Given a non-negative integer represented as a linked list of digits, plus one to the integer.
     * The digits are stored such that the most significant digit is at the head of the list.
     * 
     * reverse the original linked list, do the addition, and then reverse it back.
     * 
     * @param head
     * @return
     */

    public ListNode plusOne(ListNode head) {
        // Check whether the node is empty
        if (head == null) {
            return head;
        }
        
        // Reverse the array list
        ListNode list = reverse(head);
        // carry = 1 as we need to plus one
        int carry = 1;
        // cur points to the least significant digit 
        ListNode cur = list;
        while (cur != null && carry != 0) {
            int val = cur.val + carry;
            carry = val > 9 ? 1 : 0;
            cur.val = val % 10;

            cur = cur.next;
        }

        if (carry > 0) {
            head.next = new ListNode(carry);
        }
        
        // Reverse the linked list again
        return reverse(list);
    }
    
    private ListNode reverse(ListNode node) {
        ListNode head = null;
        ListNode cur = node;
        
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        
        return head;
    }
}
