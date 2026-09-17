package LinkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1474_test extends BaseLinkedListTest {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1474 q1474 = new Q1474();
        ListNode actualResuListNode = q1474.deleteNodes(list1(), 2, 3);
        areLinkedListsEqual(expectResultList1(), actualResuListNode);
    }

    ListNode list1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);
        ListNode node12 = new ListNode(12);
        ListNode node13 = new ListNode(13);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        return node1;
    }

    ListNode expectResultList1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node11 = new ListNode(11);
        ListNode node12 = new ListNode(12);
        node1.next = node2;
        node2.next = node6;
        node6.next = node7;
        node7.next = node11;
        node11.next = node12;
        return node1;
    }
}
