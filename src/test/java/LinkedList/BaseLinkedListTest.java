package LinkedList;

public class BaseLinkedListTest {
    public boolean areLinkedListsEqual(ListNode list1, ListNode list2) {
        while (list1 != null && list2 != null) {
            if (list1.val != list2.val) {
                return false; // Values differ
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return list1 == null && list2 == null; // Both should be null at the end
    }
}
