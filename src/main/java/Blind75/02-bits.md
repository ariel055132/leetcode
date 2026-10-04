# Binary：位元操作

[返回 Blind 75 總覽](README.md)。程式碼使用 Java 17；每個區塊獨立使用。

<a id="q371"></a>
## Q371. Sum of Two Integers

[LeetCode 題目](https://leetcode.com/problems/sum-of-two-integers/)

- **題意**：不用加減運算子求兩個整數的和。
- **解法**：XOR 算不含進位的和，AND 左移一位算進位；把進位繼續加入直到歸零。
- **範例**：1+2：01 XOR 10=11，沒有進位，答案 3。
- **複雜度**：32 位元 int 最多 O(32) 輪，視為 O(1) 時間與空間。
- **注意**：Java int 使用固定 32 位元，負數也按二補數位元運算。

```java
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }
}
```

<a id="q191"></a>
## Q191. Number of 1 Bits

[LeetCode 題目](https://leetcode.com/problems/number-of-1-bits/)

- **題意**：計算整數二進位表示中有多少個 1。
- **解法**：n & (n-1) 每次移除最低位的 1，移除幾次就是答案。
- **範例**：11=1011：1011 → 1010 → 1000 → 0，共 3 次。
- **複雜度**：O(b)，b 是設定位元數；32 位元下為 O(1)，空間 O(1)。
- **注意**：條件用 n!=0，可處理整個 int 位元模式。

```java
class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
```

<a id="q338"></a>
## Q338. Counting Bits

[LeetCode 題目](https://leetcode.com/problems/counting-bits/)

- **題意**：依序回傳 0 到 n 每個數字的設定位元數。
- **解法**：i 的答案等於 i/2 的答案，再加上最低位 i&1；較小狀態已計算完成。
- **範例**：n=5 → [0,1,1,2,1,2]，其中 5=101，答案等於 count[2]+1。
- **複雜度**：時間 O(n)，輸出 O(n)，除輸出外額外空間 O(1)。
- **注意**：n=0 時仍須回傳包含 0 的單元素陣列。

```java
class Solution {
    public int[] countBits(int n) {
        int[] answer = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            answer[i] = answer[i >>> 1] + (i & 1);
        }
        return answer;
    }
}
```

<a id="q268"></a>
## Q268. Missing Number

[LeetCode 題目](https://leetcode.com/problems/missing-number/)

- **題意**：0 到 n 的不同數字中缺少一個，找出缺少的值。
- **解法**：把所有索引 0..n 與實際值一起 XOR；成對出現的值抵消，只剩缺漏值。
- **範例**：[3,0,1] 與 0、1、2、3 XOR 後只剩 2。
- **複雜度**：時間 O(n)，額外空間 O(1)。
- **注意**：起始值設 n，補上迴圈只走到 n-1 的那一個值。

```java
class Solution {
    public int missingNumber(int[] nums) {
        int answer = nums.length;
        for (int i = 0; i < nums.length; i++) answer ^= i ^ nums[i];
        return answer;
    }
}
```

<a id="q190"></a>
## Q190. Reverse Bits

[LeetCode 題目](https://leetcode.com/problems/reverse-bits/)

- **題意**：反轉整個 32 位元的位元順序。
- **解法**：每次取輸入最低位，接到答案尾端，再對輸入做無號右移，共處理 32 次。
- **範例**：43261596 的 32 位元反轉後為 964176192；前導零也必須參與反轉。
- **複雜度**：固定 32 次，時間與額外空間皆 O(1)。
- **注意**：使用 >>>；不能只處理到 n==0，否則前導零對應的尾端位元會漏掉。

```java
class Solution {
    public int reverseBits(int n) {
        int answer = 0;
        for (int i = 0; i < 32; i++) {
            answer = (answer << 1) | (n & 1);
            n >>>= 1;
        }
        return answer;
    }
}
```

