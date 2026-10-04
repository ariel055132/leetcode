# Heap：Top K 與串流中位數

[返回 Blind 75 總覽](README.md)。程式碼使用 Java 17；各區塊獨立使用，共通 import 見總覽。原始題單的另一道 Heap 題 [Q23 Merge k Sorted Lists](06-linked-lists.md#q23) 收在鏈結串列篇，避免重複計數。

<a id="q347"></a>
## Q347. Top K Frequent Elements

[LeetCode 題目](https://leetcode.com/problems/top-k-frequent-elements/)

- **題意**：回傳出現頻率最高的 k 個不同值，答案順序不限。
- **解法**：先計頻率，再以頻率作桶索引。頻率最大不超過 n，因此從高頻桶往下收集 k 個即可。
- **範例**：[1,1,1,2,2,3]、k=2：頻率 3 的桶含 1，頻率 2 的桶含 2，輸出 [1,2]。
- **複雜度**：平均時間 O(n)，額外空間 O(n)，輸出 O(k)。
- **注意**：既有 Q347.java 是 HashMap+大小 k 的 Min Heap，時間 O(n+U log(k+1))；此處給靜態陣列的桶解法，U 為不同值數。

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int x : nums) frequency.merge(x, 1, Integer::sum);
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) buckets.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }
        int[] answer = new int[k];
        int index = 0;
        for (int f = nums.length; f >= 1; f--) {
            for (int value : buckets.get(f)) {
                answer[index++] = value;
                if (index == k) return answer;
            }
        }
        return answer;
    }
}
```

<a id="q295"></a>
## Q295. Find Median from Data Stream

[LeetCode 題目](https://leetcode.com/problems/find-median-from-data-stream/)

- **題意**：支援逐筆加入整數，並隨時回傳目前所有數值的中位數。
- **解法**：Max Heap 保存較小的一半，Min Heap 保存較大的一半。維持 lower 大小等於 upper 或多一，且 lower 所有值不大於 upper；中位數只看兩個頂端。
- **範例**：加入 1、2 後，中位數是 (1+2)/2=1.5；再加入 3，lower 頂端為 2，中位數 2。
- **複雜度**：addNum 時間 O(log n)，findMedian 時間 O(1)，總儲存空間 O(n)。
- **注意**：平均前先轉 long 避免整數加法溢位；findMedian 的前提是至少加入一個值。

```java
class MedianFinder {
    private final PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> upper = new PriorityQueue<>();
    public MedianFinder() {}
    public void addNum(int num) {
        lower.offer(num);
        upper.offer(lower.poll());
        if (lower.size() < upper.size()) lower.offer(upper.poll());
    }
    public double findMedian() {
        if (lower.size() > upper.size()) return lower.peek();
        return ((long) lower.peek() + upper.peek()) / 2.0;
    }
}
```

