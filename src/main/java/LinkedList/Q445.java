package LinkedList;

import java.util.Stack;

public class Q445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        int carry = 0;
        ListNode dummy = new ListNode();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) sum += stack1.pop();
            if (!stack2.isEmpty()) sum += stack2.pop();
            dummy.val = sum % 10;
            carry = sum / 10;
            ListNode tmp = new ListNode(carry);
            sum = carry;
            tmp.next = dummy;
            dummy = tmp;
        }
        return carry == 0 ? dummy.next : dummy;
    }
}
