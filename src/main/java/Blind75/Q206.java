package Blind75;

import LinkedList.ListNode;

public class Q206 {
    // Give the head of a singly linked list, reverse the list, and return the reversed list
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode nextNode = null;
        while (head != null) {
            nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        return prevNode;
    }
}
