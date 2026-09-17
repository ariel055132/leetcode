package LinkedList;

public class Q1474 {
    /**
     * You are given the head of a linked list and two integers m and n.
     * Traverse the linked list and remove some nodes in the following way:
     * Start with the head as the current node.
     * Keep the first m nodes starting with the current node.
     * Remove the next n nodes
     * Keep repeating steps 2 and 3 until you reach the end of the list.
     * 
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode deleteNodes(ListNode head, int m, int n) {
        // An empty list or no nodes to delete, return the original list
        if (head == null || n == 0) return head;
        // No node need to keep, return an empty linked list
        if (m == 0) return null;
        // dummy is an extra node before the head.
        // Starting there means the first (node = node.next) visits the first real node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = dummy;
        // skip counts how many nodes to keep before deleting
        int skip = m;
        // Keep m nodes
        while (node.next != null) {
            node = node.next;
            skip--;
            if (skip == 0) {
                skip = m;
                for (int i = 0; i < n; i++) {
                    if (node.next != null) {
                        // removes the node immediately after node by linking around it
                        node.next = node.next.next;
                    }
                }
            }
        }

        return dummy.next;
    }
}
