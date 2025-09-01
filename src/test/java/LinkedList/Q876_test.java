package LinkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q876_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q876 q876 = new Q876();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode actualResult = q876.middleNode(node1);
        System.out.println(actualResult.val);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q876 q876 = new Q876();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode actualResult = q876.middleNode(node1);
        System.out.println(actualResult.val);
    }
}
