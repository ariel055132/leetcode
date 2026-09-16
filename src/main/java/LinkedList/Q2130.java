package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class Q2130 {
    /**
     * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
     * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
     * The twin sum is defined as the sum of a node and its twin.
     * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
     * 
     * 1. Copy the node values into an ArrayList
     * 2. Use two pointers to check each twin pair
     * left starts at first element; right start at the last
     * Add their values and update result if the sum is larger
     * Move both pointers toward the middle
     * 
     * @param head
     * @return
     */
    public int pairSum(ListNode head) {
        int result = 0;
        List<Integer> list = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            result = Math.max(result, list.get(left) + list.get(right));
            left++;
            right--;
        }
        return result;
    }
}
