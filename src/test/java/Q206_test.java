import Blind75.Q206;
import LinkedList.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q206_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        // Input: 1 -> 2 -> 3 -> 4 -> 5
        // Output: 5 -> 4 -> 3 -> 2 -> 1
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Q206 q206 = new Q206();
        ListNode actualResult = q206.reverseList(node1);
        node5.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node1;
        Assertions.assertEquals(node5, actualResult);
    }
}
