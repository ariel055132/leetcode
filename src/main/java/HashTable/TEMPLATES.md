# HashMap Java 模板

搭配 [HashMap Pattern](README.md) 使用。先決定 key、value 與 invariant，再選擇下列方法；這些骨架可依題目調整，提交時需符合該題介面。

## 使用方式與共同前提

所有方法相容 Java 17，可將需要的方法放進同一個 `public class HashMapTemplates`，並加入以下 imports。各方法皆為 `static`，可直接從 `main` 或 JUnit 呼叫。

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
```

共同前提：輸入陣列、列表、元素、callback 與其產生的 key 皆非 null；map 不存 null value；key 的相等與 hash 語意穩定。所有模板都不修改輸入陣列。

時間分析採用平均雜湊假設。`n` 為元素數，`d` 為不同 key 數；除分組與自訂 key 另行說明外，數值 key 的建立與比較為 `O(1)`。

## 1. 頻率與相同值配對

### 建立頻率表

```java
public static Map<Integer, Long> frequencies(int[] values) {
    Map<Integer, Long> frequency = new HashMap<>();
    for (int value : values) {
        // 可變部分：value 可換成字元、餘數或其他可分類的 key。
        frequency.put(value, frequency.getOrDefault(value, 0L) + 1);
    }
    return frequency;
}
```

Invariant：每輪結束後，map 是目前已讀取元素的完整頻率表。預期時間 `O(n)`、空間 `O(d)`。

### 計算所有相同值的索引對

```java
public static long countEqualPairs(int[] values) {
    Map<Integer, Long> frequency = new HashMap<>();
    long answer = 0;
    for (int value : values) {
        long previousCount = frequency.getOrDefault(value, 0L);
        answer += previousCount; // 固定骨架：先利用歷史次數計算答案。
        frequency.put(value, previousCount + 1);
    }
    return answer;
}
```

Invariant：查詢時只計入目前位置之前的相同值，確保每個 `(j, i)` 滿足 `j < i` 且只計算一次。若把「相同原始值」改為「相同特徵」，只需改 key 的生成方式。

預期時間 `O(n)`、空間 `O(d)`；答案可能是 `n(n - 1) / 2`，因此使用 `long`。空陣列回傳 `0`。

## 2. 補數查找

```java
public static int[] findPair(int[] values, int target) {
    Map<Long, Integer> previousIndex = new HashMap<>();
    for (int i = 0; i < values.length; i++) {
        long value = values[i];
        long needed = (long) target - value; // 可變部分：配對的關係式。
        Integer previous = previousIndex.get(needed);
        if (previous != null) {
            return new int[]{previous, i};
        }
        previousIndex.put(value, i); // 固定骨架：查完才加入目前位置。
    }
    return new int[]{-1, -1};
}
```

Invariant：查詢時 map 只含 `[0, i)` 的索引。因只需一組答案，同值覆寫成最新索引仍保留合法候選。`[3, 3]`、target `6` 回傳 `[0, 1]`；`[3]` 則無解。

預期時間 `O(n)`、空間 `O(d)`。若題目改問 pair 數量，value 改成頻率；若問所有索引對，改存索引列表，並額外計入輸出成本。

## 3. 依 signature 分組

```java
public static <T, K> Map<K, List<T>> groupBy(
        List<T> items, Function<T, K> keyOf) {
    Map<K, List<T>> groups = new HashMap<>();
    for (T item : items) {
        K key = keyOf.apply(item); // 可變部分：正規化 signature。
        groups.computeIfAbsent(key, ignored -> new ArrayList<>()).add(item);
    }
    return groups;
}
```

Invariant：每輪結束後，每個已讀取元素恰好出現在其 key 對應的列表一次。需先證明 `keyOf(a).equals(keyOf(b))` 等價於題目定義的「同一組」。`computeIfAbsent` 用來按需建立列表，API 語意見 [HashMap 官方文件](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashMap.html#computeIfAbsent(K,java.util.function.Function))。

若 key 成本為常數，預期時間 `O(n)`、保存元素參照的空間 `O(n + d)`；自訂 signature 的計算、儲存及比較成本另計。各組內保留輸入順序，各組之間沒有固定順序。

### 可替換的 key 範例

以下 signature 適用於只含小寫英文字母的字串，依循環位移關係分組；也支援空字串。

```java
public static String shiftSignature(String word) {
    StringBuilder key = new StringBuilder();
    key.append(word.length()).append(':');
    for (int i = 1; i < word.length(); i++) {
        int difference = (word.charAt(i) - word.charAt(i - 1) + 26) % 26;
        key.append(difference).append(',');
    }
    return key.toString();
}
```

使用方式為 `groupBy(words, HashMapTemplates::shiftSignature)`。例如 `"az"` 與 `"ba"` 都是 `"2:25,"`；`"a"` 為 `"1:"`，空字串為 `"0:"`。

相同長度與相同相鄰差，代表選定首字元後，其餘字元都由同一規則決定，因此可由共同位移互相轉換。令 `S` 為所有輸入字元總數，此分組預期時間為 `O(n + S)`、空間上界為 `O(n + S)`，包含列表參照與 signature。

## 4. 每組保留最佳值

以下版本求「同 key 的兩個不同位置，其數值和最大」，輸入數值限定為非負整數，無合法 pair 時回傳 `-1`。

```java
public static long maxPairSumByKey(int[] values, IntUnaryOperator keyOf) {
    Map<Integer, Integer> best = new HashMap<>();
    long answer = -1;
    for (int value : values) {
        int key = keyOf.applyAsInt(value); // 可變部分：digit sum、餘數等。
        Integer previousBest = best.get(key);
        if (previousBest != null) {
            answer = Math.max(answer, (long) previousBest + value);
        }
        best.put(key, previousBest == null ? value : Math.max(previousBest, value));
    }
    return answer;
}
```

Invariant：查詢時 `best[key]` 是同 key 的歷史最大單一數值。對固定 value，previous 越大，兩數和越大；因此每組只留最大值不會丟失更佳答案。

可調整 key 與最佳值的定義，但必須重新證明較差候選可以捨棄。若允許負數，應另外記錄是否找到 pair，例如改用 `OptionalLong`，不能沿用 `-1` 作為答案初值。

key 產生為常數時間時，預期時間 `O(n)`、空間 `O(d)`；若每次 key 計算需 `O(c)`，總時間為 `O(n(1 + c))`。

## 5. Prefix Sum 加頻率

```java
public static long countSubarraysWithSum(int[] values, int target) {
    Map<Long, Long> frequency = new HashMap<>();
    frequency.put(0L, 1L); // 固定骨架：空 prefix 只放一次。
    long prefix = 0;
    long answer = 0;
    for (int value : values) {
        prefix += value; // 可變部分：元素對累積狀態的 contribution。
        long needed = prefix - target;
        answer += frequency.getOrDefault(needed, 0L);
        frequency.put(prefix, frequency.getOrDefault(prefix, 0L) + 1);
    }
    return answer;
}
```

Invariant：查詢時，frequency 保存空 prefix 及目前元素之前的所有 prefix 次數。更新 `prefix` 變數不代表已將它放入 map；必須先查詢，才能排除空區間。

可將 contribution 改為 `0 -> -1、1 -> +1`，用 target `0` 計算兩類數量相等的區間；若改成 XOR 或餘數，則要一併重新推導 `needed`。

允許正數、負數與零；空陣列回傳 `0`。預期時間 `O(n)`、空間 `O(n)`。prefix 與答案使用 `long`，例如 `100000` 個零的合法非空區間數為 `5000050000`。

## 6. Prefix Sum 加最早索引

```java
public static int longestSubarrayWithSum(int[] values, int target) {
    Map<Long, Integer> firstIndex = new HashMap<>();
    firstIndex.put(0L, -1); // 此模板使用元素索引。
    long prefix = 0;
    int longest = 0;
    for (int i = 0; i < values.length; i++) {
        prefix += values[i];
        Integer previous = firstIndex.get(prefix - target);
        if (previous != null) {
            longest = Math.max(longest, i - previous);
        }
        firstIndex.putIfAbsent(prefix, i); // 固定骨架：保留最早位置。
    }
    return longest;
}
```

Invariant：查詢時，每個 prefix 只保存最早的歷史元素索引。因右端固定，左邊界越早，區間越長；反覆出現的 prefix 不可覆蓋其最早位置。

允許負數；無非空合法區間時回傳 `0`。預期時間 `O(n)`、空間 `O(n)`。Q525 可將 `prefix += values[i]` 換成 `prefix += values[i] == 0 ? -1 : 1`，並使用 target `0`。

## 7. 最近出現位置

```java
public static boolean hasNearbyDuplicate(int[] values, int maxDistance) {
    Map<Integer, Integer> lastIndex = new HashMap<>();
    for (int i = 0; i < values.length; i++) {
        Integer previous = lastIndex.get(values[i]);
        if (previous != null && i - previous <= maxDistance) {
            return true;
        }
        lastIndex.put(values[i], i); // 固定骨架：保留最新位置。
    }
    return false;
}
```

前提為 `maxDistance >= 0`。Invariant：查詢時 map 保存每個值最近的歷史索引。對固定右端，最近位置已是最短距離；若它不符合上限，更早的位置也不會符合。

`[7, 1, 7, 7]`、距離上限 `1` 應回傳 true：處理索引 `2` 時即使未找到合法 pair，也必須更新位置，讓索引 `3` 能配到它。距離上限 `0` 時不能使用同一位置，回傳 false。

預期時間 `O(n)`、空間 `O(d)`；此版本保存全域最近位置，不是只保存固定視窗。

## 快速檢查

| 方法 | 輸入 | 預期結果或性質 |
| --- | --- | --- |
| `frequencies` | `[4, 4, 2, 4]` | `{4: 3, 2: 1}` |
| `countEqualPairs` | `[4, 4, 2, 4]` | `3` |
| `findPair` | `[3]`、target `6` | `[-1, -1]` |
| `findPair` | `[3, 3]`、target `6` | `[0, 1]` |
| `groupBy` 搭配 `shiftSignature` | `["az", "ba", "a", "", "z"]` | 三組：`["az", "ba"]`、`["a", "z"]`、`[""]`，不比較組間順序 |
| `maxPairSumByKey` | `[5, 1, 3]`、key 為 `value % 2` | `8`，不能只保留上一個數 |
| `countSubarraysWithSum` | `[0, 0, 0]`、target `0` | `6` |
| `longestSubarrayWithSum` | `[1, -1, 1, -1]`、target `0` | `4` |
| `hasNearbyDuplicate` | `[7, 1, 7, 7]`、距離 `1` | `true` |

遇到新題目時，先替模板寫下新的 key/value 定義，再用能區分「先查或先更新」、「最早或最新」、「頻率或存在性」的小案例驗證。
