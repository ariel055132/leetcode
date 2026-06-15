package LinkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2095_test extends BaseLinkedListTest {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2095 q2095 = new Q2095();
        ListNode expectResult = expectResult1();
        ListNode actualResult = q2095.deleteMiddle(list1());
        System.out.println(areLinkedListsEqual(expectResult, actualResult));
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q2095 q2095 = new Q2095();
        ListNode expectResult = expectResult2();
        ListNode actualResult = q2095.deleteMiddle(list2());
        System.out.println(areLinkedListsEqual(expectResult, actualResult));
    }

    ListNode list1() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        return head;
    }

    ListNode expectResult1() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        return head;
    }

    ListNode list2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        return node1;
    }

    ListNode expectResult2() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return head;
    }
}
