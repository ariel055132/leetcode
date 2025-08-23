package Blind75;

import LinkedList.ListNode;

public class Q21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list1Head = list1;
        ListNode list2Head = list2;
        ListNode head = null; // return result

        // Edge Case 1. Both Lists are empty, return head, which equals to null
        if (list1 == null && list2 == null) {
            return head;
        }
        // Edge Case 2. Only one of the list is empty, return the non-empty list
        if (list1 == null && list2 != null) {
            return list2;
        }
        if (list2 == null && list1 != null) {
            return list1;
        }

        // Start to traverse the linked-list
        if (list1.val <= list2.val) {
            head = list1Head;
            list1Head = list1Head.next;
        } else {
            head = list2Head;
            list2Head = list2Head.next;
        }

        // Node used to traverse the linked list
        ListNode currentNode = head;
        while (list1Head != null && list2Head != null) {
            if (list1Head.val <= list2Head.val) {
                currentNode.setNext(list1Head);
                list1Head = list1Head.getNext();
            } else {
                currentNode.setNext(list2Head);
                list2Head = list2Head.getNext();
            }
            currentNode = currentNode.getNext();
        }

        if (list1Head != null) {
            currentNode.setNext(list1Head);
        } else {
            currentNode.setNext(list2Head);
        }
        return head;
    }
}
