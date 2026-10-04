# Linked List：串列與指標

[返回 Blind 75 總覽](README.md)。程式碼使用 Java 17；各區塊獨立使用，ListNode 與共通 import 見總覽。

<a id="q206"></a>
## Q206. Reverse Linked List

[LeetCode 題目](https://leetcode.com/problems/reverse-linked-list/)

- **題意**：原地反轉單向鏈結串列並回傳新頭節點。
- **解法**：prev 是已反轉前綴，current 是未處理部分；先保存 next，再反轉目前指向並向前移動。
- **範例**：1→2→3：依序變成 1→null、2→1、3→2→1，回傳 3。
- **複雜度**：時間 O(n)，額外空間 O(1)。
- **注意**：既有版也是此迭代解法；若先改 next 卻沒保存原本下一節點，就會丟失尾段。

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
```

<a id="q141"></a>
## Q141. Linked List Cycle

[LeetCode 題目](https://leetcode.com/problems/linked-list-cycle/)

- **題意**：判斷鏈結串列是否有環；相同值不代表相同節點。
- **解法**：slow 每輪一步、fast 每輪兩步。若有環，進入環後相對距離每次變一，最後一定相遇；無環則 fast 到尾端。
- **範例**：3→2→0→-4，尾端連回節點 2，兩個指標最後相遇，回傳 true。
- **複雜度**：時間 O(n)，額外空間 O(1)，n 是可到達的不同節點數。
- **注意**：既有版 head==null 回傳 true 且未保護 fast.next；以下修正這兩個條件。

```java
class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
```

<a id="q21"></a>
## Q21. Merge Two Sorted Lists

[LeetCode 題目](https://leetcode.com/problems/merge-two-sorted-lists/)

- **題意**：把兩個有序鏈結串列合併，重用既有節點。
- **解法**：dummy 避免頭節點特判；tail 每次接上兩個尚未消耗頭節點中較小者，最後接上剩餘尾段。
- **範例**：[1,2,4] 與 [1,3,4] → [1,1,2,3,4,4]。
- **複雜度**：時間 O(m+n)，額外空間 O(1)。
- **注意**：會改動 next 連結。既有版先挑頭節點再合併，以下以 dummy 簡化相同邏輯。

```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
}
```

<a id="q23"></a>
## Q23. Merge k Sorted Lists

[LeetCode 題目](https://leetcode.com/problems/merge-k-sorted-lists/)

- **題意**：合併 k 個有序鏈結串列。
- **解法**：Min Heap 只保存各串列尚未消耗的頭。取出全域最小節點後，把同串列的下一節點補入。
- **範例**：[[1,4,5],[1,3,4],[2,6]]：依序取出 1、1、2、3、4、4、5、6。
- **複雜度**：時間 O(k+N log(k+1))，額外空間 O(k)，N 為總節點數；重用節點輸出。
- **注意**：原始題單在 Linked List 與 Heap 都列到此題，總覽只計一次。輸入串列假設不共用節點。

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) if (node != null) heap.offer(node);
        ListNode dummy = new ListNode(0), tail = dummy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            if (node.next != null) heap.offer(node.next);
            tail.next = node;
            tail = node;
        }
        tail.next = null;
        return dummy.next;
    }
}
```

<a id="q19"></a>
## Q19. Remove Nth Node From End of List

[LeetCode 題目](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

- **題意**：刪除倒數第 n 個節點，題目保證 n 有效。
- **解法**：slow、fast 從 dummy 開始，先讓 fast 領先 n 步，再同步走到 fast 位於尾端；slow 就在待刪節點之前。
- **範例**：[1,2,3,4,5]、n=2：最後 slow 位於 3，跳過 4，得到 [1,2,3,5]。
- **複雜度**：時間 O(L)，額外空間 O(1)，L 是串列長度。
- **注意**：dummy 讓刪除原本 head 與中間節點使用相同操作。

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        for (int i = 0; i < n; i++) fast = fast.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
```

<a id="q143"></a>
## Q143. Reorder List

[LeetCode 題目](https://leetcode.com/problems/reorder-list/)

- **題意**：將 L0→L1→…→Ln 重排成 L0→Ln→L1→Ln-1→…，不可只交換值。
- **解法**：快慢指標找前半尾端，斷開並反轉後半，再交錯合併兩半。
- **範例**：[1,2,3,4,5]：前半 [1,2,3]、反轉後半 [5,4]，交錯成 [1,5,2,4,3]。
- **複雜度**：時間 O(n)，額外空間 O(1)。
- **注意**：必須先 slow.next=null 斷開兩段，合併時保存雙方原本的 next，避免形成環。

```java
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode current = slow.next;
        slow.next = null;
        ListNode second = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = second;
            second = current;
            current = next;
        }
        ListNode first = head;
        while (second != null) {
            ListNode nextFirst = first.next, nextSecond = second.next;
            first.next = second;
            second.next = nextFirst;
            first = nextFirst;
            second = nextSecond;
        }
    }
}
```

