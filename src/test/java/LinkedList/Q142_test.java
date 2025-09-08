package LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q142_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q142 q142 = new Q142();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        ListNode expectResult = node2;
        ListNode actualResult = q142.detectCycle(node1);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q142 q142 = new Q142();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = node1;
        ListNode expectResult = node1;
        ListNode actualResult = q142.detectCycle(node1);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q142 q142 = new Q142();
        ListNode node1 = new ListNode(1);
        ListNode expectResult = null;
        ListNode actualResult = q142.detectCycle(node1);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
