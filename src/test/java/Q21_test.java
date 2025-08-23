import Blind75.Q21;
import LinkedList.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Q21_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q21 q21 = new Q21();
        // 1 -> 2 -> 4
        ListNode one = one();
        // 1 -> 2 -> 3
        ListNode two = two();
        ListNode result = q21.mergeTwoLists(one, two);
        System.out.println(result);
    }

    ListNode one() {
        // 1 -> 2 -> 4
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.val = 1;
        node1.next = node2;
        node2.val = 2;
        node2.next = node3;
        node3.val = 4;
        return node1;
    }

    ListNode two() {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.val = 1;
        node1.next = node2;
        node2.val = 2;
        node2.next = node3;
        node3.val = 3;
        return node1;
    }
}
