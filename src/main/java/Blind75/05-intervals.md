# Interval：區間與排程

[返回 Blind 75 總覽](README.md)。程式碼使用 Java 17；各區塊獨立使用，共通 import 見總覽。

<a id="q57"></a>
## Q57. Insert Interval

[LeetCode 題目](https://leetcode.com/problems/insert-interval/)

- **題意**：把一個新區間插入已按起點排序且互不重疊的閉區間，合併重疊部分。
- **解法**：分三段：先收下完全在左邊的區間，接著合併所有與新區間重疊者，最後收下右邊剩餘區間。
- **範例**：[[1,3],[6,9]] 插入 [2,5]：與 [1,3] 合成 [1,5]，結果 [[1,5],[6,9]]。
- **複雜度**：時間 O(n)，輸出與結果容器 O(n)。
- **注意**：本題閉區間端點相等也要合併；以下複製輸出區間，不修改輸入。

```java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>();
        int i = 0, start = newInterval[0], end = newInterval[1];
        while (i < intervals.length && intervals[i][1] < start) {
            answer.add(intervals[i++].clone());
        }
        while (i < intervals.length && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        answer.add(new int[] {start, end});
        while (i < intervals.length) answer.add(intervals[i++].clone());
        return answer.toArray(new int[0][]);
    }
}
```

<a id="q56"></a>
## Q56. Merge Intervals

[LeetCode 題目](https://leetcode.com/problems/merge-intervals/)

- **題意**：合併所有重疊的閉區間。
- **解法**：依起點排序後，後來的區間只可能與結果中的最後一段重疊；重疊就延長最後一段，否則開新段。
- **範例**：[[1,3],[2,6],[8,10]]：前兩段合成 [1,6]，留下 [[1,6],[8,10]]。
- **複雜度**：時間 O(n log n)，副本與排序額外空間 O(n)，輸出 O(n)。
- **注意**：[1,4] 與 [4,5] 在本題要合併；排序副本保留原始順序。

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] sorted = intervals.clone();
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> answer = new ArrayList<>();
        for (int[] current : sorted) {
            if (answer.isEmpty() || answer.get(answer.size() - 1)[1] < current[0]) {
                answer.add(current.clone());
            } else {
                int[] last = answer.get(answer.size() - 1);
                last[1] = Math.max(last[1], current[1]);
            }
        }
        return answer.toArray(new int[0][]);
    }
}
```

<a id="q435"></a>
## Q435. Non-overlapping Intervals

[LeetCode 題目](https://leetcode.com/problems/non-overlapping-intervals/)

- **題意**：刪除最少區間，使剩下區間互不重疊；端點相接可保留。
- **解法**：改成最多能保留幾段。按結束時間排序，每次選目前能接上的最早結束區間，為後續留下最多空間。
- **範例**：[[1,2],[2,3],[3,4],[1,3]]：保留前三段，只刪除 [1,3]，答案 1。
- **複雜度**：時間 O(n log n)，副本與排序空間 O(n)。
- **注意**：與 Q56 不同，start==previousEnd 合法；比較器不用相減以免溢位。

```java
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int[][] sorted = intervals.clone();
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[1], b[1]));
        int end = Integer.MIN_VALUE, kept = 0;
        for (int[] current : sorted) {
            if (current[0] >= end) {
                kept++;
                end = current[1];
            }
        }
        return sorted.length - kept;
    }
}
```

<a id="q252"></a>
## Q252. Meeting Rooms

[LeetCode 題目](https://leetcode.com/problems/meeting-rooms/)

- **題意**：Premium 題採常見題意：判斷一個人是否能參加所有會議；每段 start<end，前一場結束時可開始下一場。
- **解法**：按開始時間排序，檢查相鄰會議是否重疊；排序後若存在衝突，一定能在相鄰位置發現。
- **範例**：[[0,30],[5,10],[15,20]]：5<30，無法全部參加，回傳 false。
- **複雜度**：時間 O(n log n)，副本與排序空間 O(n)。
- **注意**：介面採 canAttendMeetings(int[][] intervals)；空題單回傳 true。

```java
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int[][] sorted = intervals.clone();
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i][0] < sorted[i - 1][1]) return false;
        }
        return true;
    }
}
```

<a id="q253"></a>
## Q253. Meeting Rooms II

[LeetCode 題目](https://leetcode.com/problems/meeting-rooms-ii/)

- **題意**：Premium 題採常見題意：會議 start<end，求同時容納所有會議所需的最少房間數。
- **解法**：按開始時間處理，Min Heap 保存進行中會議的結束時間。先移除已結束的會議，再加入目前會議；最大 heap 大小就是最大同時需求。
- **範例**：[[0,30],[5,10],[15,20]]：時間 5 有兩場；時間 15 前先移除 10，仍只需 2 間。
- **複雜度**：時間 O(n log n)，額外空間 O(n)。
- **注意**：介面採 minMeetingRooms(int[][] intervals)；end<=start 就能釋放房間。

```java
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[][] sorted = intervals.clone();
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> active = new PriorityQueue<>();
        int best = 0;
        for (int[] meeting : sorted) {
            while (!active.isEmpty() && active.peek() <= meeting[0]) active.poll();
            active.offer(meeting[1]);
            best = Math.max(best, active.size());
        }
        return best;
    }
}
```

