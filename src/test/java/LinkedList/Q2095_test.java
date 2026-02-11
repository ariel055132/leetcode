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
}
