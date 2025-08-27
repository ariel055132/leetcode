import Blind75.Q141;
import Blind75.Q15;
import LinkedList.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q141_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        Q141 q141 = new Q141();
        boolean actualResult = q141.hasCycle(node1);
        boolean expectResult = true;
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = node1;
        Q141 q141 = new Q141();
        boolean expectResult = true;
        boolean actualResult = q141.hasCycle(node1);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void test3() {
        ListNode node1 = new ListNode(1);
        node1.next = null;
        Q141 q141 = new Q141();
        boolean expectResult = false;
        boolean actualResult = q141.hasCycle(node1);
        Assertions.assertEquals(expectResult, actualResult);
    }
}
