package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Q142 {
    public ListNode detectCycle(ListNode head) {
        /*
         * Traverse the linked list
         * Save the list value into the set while traversal
         * When another element with same value is added to the set
         * Just find that it has a cycle
         *
         * Time Complexity: O(n), where n is the length of the linked list
         * Space Complexity: O(n)
         */
        if (head == null) {
            return null;
        }
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return head;
            } else {
                nodeSet.add(head);
                head = head.next;
            }
        }
        return null;
    }
}
