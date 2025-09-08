package LinkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q445_test {
    @Test
    @DisplayName("Example 1")
    void example1() {
        Q445 q445 = new Q445();
        ListNode dummy1 = example1_Node1();
        ListNode dummy2 = example1_Node2();
        ListNode dummy3 = q445.addTwoNumbers(dummy1, dummy2);
        System.out.println(dummy3.val);
        System.out.println(dummy3.next.val);
        System.out.println(dummy3.next.next.val);
        System.out.println(dummy3.next.next.next.val);
    }

    ListNode example1_Node1() {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }

    ListNode example1_Node2() {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        return node1;
    }
}
