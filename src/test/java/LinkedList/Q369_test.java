package LinkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q369_test extends BaseLinkedListTest {
    @Test 
    @DisplayName("Test 1")
    void test1() {
        Q369 q369 = new Q369();
        ListNode actualResultList1 = q369.plusOne(list1());
        areLinkedListsEqual(actualResultList1, expectResultList1());
    }

    @Test 
    @DisplayName("Test 2")
    void test2() {
        Q369 q369 = new Q369();
        ListNode actualResultList2 = q369.plusOne(list2());
        areLinkedListsEqual(actualResultList2, expectResultList2());
    }


    ListNode list1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        return node1;
    }

    ListNode expectResultList1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        return node1;
    }

    ListNode list2() {
        ListNode node1 = new ListNode(0);
        return node1;
    }

    ListNode expectResultList2() {
        ListNode node1 = new ListNode(1);
        return node1;
    }
}
