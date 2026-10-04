# Array：陣列、雜湊與雙指標

[返回 Blind 75 總覽](README.md)。程式碼使用 Java 17；各區塊獨立使用，共通 import 與型別見總覽。

<a id="q1"></a>
## Q1. Two Sum

[LeetCode 題目](https://leetcode.com/problems/two-sum/)

- **題意**：回傳和等於 target 的兩個不同索引。
- **解法**：HashMap 保存已掃描的值與索引。先查補數，再放入目前值，因此不會重用自己。
- **範例**：[2,7,11,15]、target=9：讀 2 時存 {2:0}，讀 7 找到補數 2，回傳 [0,1]。
- **複雜度**：平均時間 O(n)，額外空間 O(n)。
- **注意**：既有 Q1.java 同時有暴力 O(n²) 與 HashMap 版；以下採 HashMap。

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (index.containsKey(complement)) {
                return new int[] {index.get(complement), i};
            }
            index.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
```

<a id="q121"></a>
## Q121. Best Time to Buy and Sell Stock

[LeetCode 題目](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

- **題意**：只能買賣一次，買入必須早於賣出，求最大獲利。
- **解法**：保存目前之前最低買價；每個價格作為賣價更新答案，再更新最低價。
- **範例**：[7,1,5,3,6,4]：最低價降到 1，賣價 6 時獲利 5。
- **複雜度**：時間 O(n)，額外空間 O(1)。
- **注意**：下跌市場回傳 0。既有版以 left 保存最低價索引，核心相同。

```java
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, best = 0;
        for (int price : prices) {
            best = Math.max(best, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return best;
    }
}
```

<a id="q217"></a>
## Q217. Contains Duplicate

[LeetCode 題目](https://leetcode.com/problems/contains-duplicate/)

- **題意**：判斷陣列是否存在重複值。
- **解法**：HashSet 只保存已出現的值；插入失敗就是重複。
- **範例**：[1,2,3,1]：最後一個 1 已在 set 中，回傳 true。
- **複雜度**：平均時間 O(n)，額外空間 O(n)。
- **注意**：既有版即為此解法；不必排序或建立所有頻率。

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (!seen.add(x)) return true;
        }
        return false;
    }
}
```

<a id="q238"></a>
## Q238. Product of Array Except Self

[LeetCode 題目](https://leetcode.com/problems/product-of-array-except-self/)

- **題意**：每格回傳除自己以外所有元素的乘積；不可使用除法。
- **解法**：第一趟把左側乘積寫入答案；第二趟由右往左，把右側乘積乘進去。左右都不包含自己，零也自然處理。
- **範例**：[1,2,3,4]：左乘積為 [1,1,2,6]；乘入右側後為 [24,12,8,6]。
- **複雜度**：時間 O(n)，除輸出陣列外額外空間 O(1)。
- **注意**：既有 Q238.java 使用除法且未正確處理零；以下為符合題意的替代解法。

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }
        return answer;
    }
}
```

<a id="q53"></a>
## Q53. Maximum Subarray

[LeetCode 題目](https://leetcode.com/problems/maximum-subarray/)

- **題意**：求非空連續子陣列的最大總和。
- **解法**：Kadane：以目前元素結尾的最佳值，只可能是從自己重開，或接上前一段。
- **範例**：[-2,1,-3,4,-1,2,1,-5,4]：最佳連續區間 [4,-1,2,1] 的和為 6。
- **複雜度**：時間 O(n)，額外空間 O(1)。
- **注意**：以 nums[0] 初始化，不能把非空答案預設為 0，否則全負數會錯。

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int ending = nums[0], best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ending = Math.max(nums[i], ending + nums[i]);
            best = Math.max(best, ending);
        }
        return best;
    }
}
```

<a id="q152"></a>
## Q152. Maximum Product Subarray

[LeetCode 題目](https://leetcode.com/problems/maximum-product-subarray/)

- **題意**：求非空連續子陣列的最大乘積。
- **解法**：負數會交換最大與最小的角色，同時保存以目前位置結尾的最大、最小乘積。
- **範例**：[2,3,-2,4]：最大結尾乘積依序為 2、6、-2、4，全域最大為 6。
- **複雜度**：時間 O(n)，額外空間 O(1)。
- **注意**：更新兩個狀態時必須使用上一輪的值；零會讓後續狀態自然重開。

```java
class Solution {
    public int maxProduct(int[] nums) {
        int high = nums[0], low = nums[0], best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i], oldHigh = high, oldLow = low;
            high = Math.max(x, Math.max(oldHigh * x, oldLow * x));
            low = Math.min(x, Math.min(oldHigh * x, oldLow * x));
            best = Math.max(best, high);
        }
        return best;
    }
}
```

<a id="q153"></a>
## Q153. Find Minimum in Rotated Sorted Array

[LeetCode 題目](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

- **題意**：不同元素組成的排序陣列經旋轉後，找出最小值。
- **解法**：比較 mid 與 right：mid 較大時最小值一定在右半；否則 mid 本身仍可能是最小值。
- **範例**：[3,4,5,1,2]：5 > 2，left 移到 3，最後收斂到值 1。
- **複雜度**：時間 O(log n)，額外空間 O(1)。
- **注意**：使用 right=mid 保留候選，搭配 left<right；本題沒有重複值。

```java
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }
}
```

<a id="q33"></a>
## Q33. Search in Rotated Sorted Array

[LeetCode 題目](https://leetcode.com/problems/search-in-rotated-sorted-array/)

- **題意**：在無重複值的旋轉排序陣列搜尋 target 的索引，找不到回傳 -1。
- **解法**：每輪至少一半有序。先辨認有序半邊，再判斷 target 是否落在其範圍內。
- **範例**：[4,5,6,7,0,1,2]、target=0：左半有序但不含 0，轉往右半，找到 index 4。
- **複雜度**：時間 O(log n)，額外空間 O(1)。
- **注意**：先檢查 nums[mid]==target；縮減區間時排除已檢查的 mid。

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}
```

<a id="q15"></a>
## Q15. 3Sum

[LeetCode 題目](https://leetcode.com/problems/3sum/)

- **題意**：列出和為 0 的所有不重複三數值組合。
- **解法**：排序後固定第一個索引，另外兩個用相向指標。固定索引與找到答案後的端點都跳過重複值。
- **範例**：[-1,0,1,2,-1,-4] 排序後，可找到 [-1,-1,2] 與 [-1,0,1]。
- **複雜度**：時間 O(n²)；排序副本 O(n)，輸出 K 組另需 O(K)。
- **注意**：既有版使用 HashSet 去重；以下直接跳過重複值，並複製輸入避免排序副作用。

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int[] a = nums.clone();
        Arrays.sort(a);
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i + 2 < a.length; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;
            if (a[i] > 0) break;
            int left = i + 1, right = a.length - 1;
            while (left < right) {
                long sum = (long) a[i] + a[left] + a[right];
                if (sum < 0) left++;
                else if (sum > 0) right--;
                else {
                    answer.add(List.of(a[i], a[left], a[right]));
                    int lv = a[left], rv = a[right];
                    while (left < right && a[left] == lv) left++;
                    while (left < right && a[right] == rv) right--;
                }
            }
        }
        return answer;
    }
}
```

<a id="q11"></a>
## Q11. Container With Most Water

[LeetCode 題目](https://leetcode.com/problems/container-with-most-water/)

- **題意**：選兩條垂直線，最大化較矮高度乘上兩線距離的面積。
- **解法**：先更新面積，再移動較矮的一端。保留短邊只縮小寬度，無法改善目前答案，所以短邊可排除。
- **範例**：[1,8,6,2,5,4,8,3,7]：index 1 與 8 的面積為 min(8,7)×7=49。
- **複雜度**：時間 O(n)，額外空間 O(1)。
- **注意**：不能排序，高度原本的位置決定寬度；既有版也是相向指標。

```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, best = 0;
        while (left < right) {
            best = Math.max(best, Math.min(height[left], height[right]) * (right - left));
            if (height[left] <= height[right]) left++;
            else right--;
        }
        return best;
    }
}
```
