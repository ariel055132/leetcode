package LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q19_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q19 q19 = new Q19();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        int n = 2;
        ListNode actualResult = q19.removeNthFromEnd(node1, n);
        System.out.println(actualResult.val); // 1
        System.out.println(actualResult.next.val); // 2
        System.out.println(actualResult.next.next.val); // 3
        System.out.println(actualResult.next.next.next.val); // 5
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q19 q19 = new Q19();
        ListNode node1 = new ListNode(1);
        int n = 1;
        ListNode expectResult = null;
        ListNode actualResult = q19.removeNthFromEnd(node1, n);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 3")
    void test3() {
        Q19 q19 = new Q19();
        int n = 1;
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode actualResult = q19.removeNthFromEnd(node1, n);
        System.out.println(actualResult.val);
    }
}
