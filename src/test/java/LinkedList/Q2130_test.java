package LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2130_test {
    @Test 
    @DisplayName("Test 1")
    void test1() {
        Q2130 q2130 = new Q2130();
        ListNode list = list1();
        int expectResult = 6;
        int actualResult = q2130.pairSum(list);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 2")
    void test2() {
        Q2130 q2130 = new Q2130();
        ListNode list = list2();
        int expectResult = 7;
        int actualResult = q2130.pairSum(list);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test 
    @DisplayName("Test 3")
    void test3() {
        Q2130 q2130 = new Q2130();
        ListNode list = list3();
        int expectResult = 100001;
        int actualResult = q2130.pairSum(list);
        Assertions.assertEquals(expectResult, actualResult);
    }


    /**
     * 5 -> 4 -> 2 -> 1
     * 5 + 1 = 6
     * 4 + 2 = 6
     * 
     * @return
     */
    ListNode list1() {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }

    /**
     * 4 -> 2 -> 2 -> 3
     * 4 + 3 = 7
     * 2 + 2 = 4
     * 7 > 4 => 7
     * 
     * @return
     */
    ListNode list2() {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }

    /**
     * 1 -> 100000
     * 1 + 100000 = 100001
     * 
     * @return
     */
    ListNode list3() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(100000);
        node1.next = node2;
        return node1;
    }
}
