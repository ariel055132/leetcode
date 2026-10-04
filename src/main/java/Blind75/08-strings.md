# String：字串、滑動視窗與回文

[返回 Blind 75 總覽](README.md)。程式碼使用 Java 17；各區塊獨立使用，共通 import 見總覽。

<a id="q3"></a>
## Q3. Longest Substring Without Repeating Characters

[LeetCode 題目](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

- **題意**：求不含重複字元的最長連續子字串長度。
- **解法**：保存每個字元最後出現的位置；遇到重複時，把左界跳到上一次位置的下一格，但不能往回移。
- **範例**：abba：看到第二個 b 時 left 跳到 2；最後 a 的舊位置在視窗外，left 保持 2，答案 2。
- **複雜度**：平均時間 O(n)，額外空間 O(min(n,Σ))，Σ 是字元集合大小。
- **注意**：Math.max(left,last+1) 是關鍵；此版本按 Java char 處理題目字元。

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> last = new HashMap<>();
        int left = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            left = Math.max(left, last.getOrDefault(c, -1) + 1);
            last.put(c, right);
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}
```

<a id="q424"></a>
## Q424. Longest Repeating Character Replacement

[LeetCode 題目](https://leetcode.com/problems/longest-repeating-character-replacement/)

- **題意**：最多替換 k 個大寫字母，求能全部變成同字母的最長連續區間。
- **解法**：視窗長度減去其中最高字頻，就是所需替換數；超過 k 就收縮左界。每次重算 26 格的真正最高頻率，維持合法視窗。
- **範例**：AABABBA、k=1：AABA 中 A 出現 3 次，4-3=1，答案可達 4。
- **複雜度**：時間 O(26n)=O(n)，額外空間 O(26)=O(1)。
- **注意**：既有 Q424.java 只有回傳 0 的骨架；以下是完整解法。

```java
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            while (right - left + 1 - maximum(count) > k) {
                count[s.charAt(left++) - 'A']--;
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
    private int maximum(int[] count) {
        int best = 0;
        for (int frequency : count) best = Math.max(best, frequency);
        return best;
    }
}
```

<a id="q76"></a>
## Q76. Minimum Window Substring

[LeetCode 題目](https://leetcode.com/problems/minimum-window-substring/)

- **題意**：求 s 中涵蓋 t 所有字元及其重複次數的最短連續子字串。
- **解法**：need 記錄還缺的次數，missing 記錄還缺的總字元數。右界補齊後，反覆收縮左界並記錄最短合法視窗。
- **範例**：ADOBECODEBANC、ABC：第一次補齊可得到 ADOBEC，繼續掃描與收縮後得到 BANC。
- **複雜度**：時間 O(|s|+|t|)，ASCII 計數空間 O(1)，回傳字串另需 O(答案長度)。
- **注意**：t 中重複字元不可只用 set；本題字元為英文字母，128 格陣列足夠。

```java
class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) need[t.charAt(i)]++;
        int missing = t.length(), left = 0, bestStart = 0, bestLength = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            if (need[s.charAt(right)]-- > 0) missing--;
            while (missing == 0) {
                if (right - left + 1 < bestLength) {
                    bestStart = left;
                    bestLength = right - left + 1;
                }
                if (++need[s.charAt(left++)] > 0) missing++;
            }
        }
        return bestLength == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLength);
    }
}
```

<a id="q242"></a>
## Q242. Valid Anagram

[LeetCode 題目](https://leetcode.com/problems/valid-anagram/)

- **題意**：判斷兩字串的字母與出現次數是否完全相同。
- **解法**：長度相同後，用 26 格計數對 s 加一、對 t 減一；全部歸零才相同。
- **範例**：anagram 與 nagaram：每個字母的加減完全抵消，回傳 true。
- **複雜度**：時間 O(n)，額外空間 O(26)=O(1)。
- **注意**：本題是小寫英文字母。既有檔案另外提供 HashMap 與排序兩種版本。

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int value : count) if (value != 0) return false;
        return true;
    }
}
```

<a id="q49"></a>
## Q49. Group Anagrams

[LeetCode 題目](https://leetcode.com/problems/group-anagrams/)

- **題意**：將互為 anagram 的字串分到同一組。
- **解法**：每個單字排序後的字串作為標準 key；相同字母多重集合會產生相同 key，再用 Map 分組。
- **範例**：eat、tea、ate 都產生 aet，因此放在同一組；tan、nat 產生 ant。
- **複雜度**：時間 O(n+Σ Li log(Li+1))，n 為字串數、Li 為各字串長度；key、分組與暫存空間 O(T+n)，T 為總字元數。
- **注意**：輸出組別順序不限；保留原始字串，排序只用於產生 key。

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : strs) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);
            groups.computeIfAbsent(key, ignored -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(groups.values());
    }
}
```

<a id="q20"></a>
## Q20. Valid Parentheses

[LeetCode 題目](https://leetcode.com/problems/valid-parentheses/)

- **題意**：判斷三種括號是否依正確型別與巢狀順序配對。
- **解法**：遇到左括號就把期待的右括號推入 stack；遇到右括號必須等於 stack 頂端，最後 stack 必須為空。
- **範例**：([])：依序期待 )、]，讀到 ]、) 時依序彈出，回傳 true。
- **複雜度**：時間 O(n)，額外空間 O(n)。
- **注意**：既有版用 Stack；以下用 ArrayDeque。空字串在此延伸定義為有效，官方輸入長度至少為 1。

```java
class Solution {
    public boolean isValid(String s) {
        Deque<Character> expected = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') expected.push(')');
            else if (c == '[') expected.push(']');
            else if (c == '{') expected.push('}');
            else if (expected.isEmpty() || expected.pop() != c) return false;
        }
        return expected.isEmpty();
    }
}
```

<a id="q125"></a>
## Q125. Valid Palindrome

[LeetCode 題目](https://leetcode.com/problems/valid-palindrome/)

- **題意**：忽略非英數字元與大小寫後，判斷是否為回文。
- **解法**：左右指標先跳過無效字元，再逐字元轉小寫比較；匹配後一起向內移動。
- **範例**：A man, a plan, a canal: Panama 過濾後左右對稱，回傳 true。
- **複雜度**：時間 O(n)，額外空間 O(1)。
- **注意**：既有版先建立小寫字串，最壞額外空間 O(n)；此版本避免建立整份正規化字串。

```java
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```

<a id="q5"></a>
## Q5. Longest Palindromic Substring

[LeetCode 題目](https://leetcode.com/problems/longest-palindromic-substring/)

- **題意**：回傳最長的連續回文子字串。
- **解法**：回文有單字元中心與雙字元中心兩種。枚舉每個中心往外擴張，保存最長範圍。
- **範例**：babad：以 index 1 的 a 為中心，可擴成 bab；aba 也是合法同長答案。
- **複雜度**：時間 O(n²)，掃描額外空間 O(1)，輸出字串 O(答案長度)。
- **注意**：用 start=i-(length-1)/2 統一奇數與偶數中心的左界。

```java
class Solution {
    public String longestPalindrome(String s) {
        int start = 0, bestLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int length = Math.max(expand(s, i, i), expand(s, i, i + 1));
            if (length > bestLength) {
                start = i - (length - 1) / 2;
                bestLength = length;
            }
        }
        return s.substring(start, start + bestLength);
    }
    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
```

<a id="q647"></a>
## Q647. Palindromic Substrings

[LeetCode 題目](https://leetcode.com/problems/palindromic-substrings/)

- **題意**：計算所有回文子字串數；索引不同即視為不同子字串。
- **解法**：枚舉 2n-1 個奇偶中心，每成功擴張一層，就多找到一個回文。每段回文有唯一中心，不會重複計數。
- **範例**：aaa：三個單字元、兩個 aa、一個 aaa，共 6 個。
- **複雜度**：時間 O(n²)，額外空間 O(1)。
- **注意**：這裡計算索引區間，不能用 Set<String> 去掉相同內容。

```java
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            int left = center / 2, right = left + center % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}
```

<a id="q271"></a>
## Q271. Encode and Decode Strings

[LeetCode 題目](https://leetcode.com/problems/encode-and-decode-strings/)

- **題意**：Premium 題採常見題意：將字串清單編成單一字串，且能無損還原，內容可含任意分隔字元與空字串。
- **解法**：每段編成「長度#內容」。decode 先讀到 # 取得長度，再精確讀取指定長度的內容，因此內容中的 # 不會混淆邊界。
- **範例**：["", "a#b"] 編成 0#3#a#b，先讀長度 0，再讀長度 3，可還原兩個字串。
- **複雜度**：時間與輸出空間 O(B)，B 是編碼後總長，包含所有長度標頭。
- **注意**：介面採 Codec.encode(List<String>) / decode(String)。長度用 Java UTF-16 code unit，編解碼必須用相同定義；decode 假設輸入由 encode 產生。

```java
class Codec {
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs) encoded.append(s.length()).append('#').append(s);
        return encoded.toString();
    }
    public List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            int separator = s.indexOf('#', index);
            int length = Integer.parseInt(s.substring(index, separator));
            int start = separator + 1;
            decoded.add(s.substring(start, start + length));
            index = start + length;
        }
        return decoded;
    }
}
```
