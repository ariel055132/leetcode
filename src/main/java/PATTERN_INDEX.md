# Java 題解考點分類索引

原本位於 `src/main/java` 根目錄、未宣告 `package` 的 **162 個 Java 題解**，已依下列考點搬入對應 package。另有 **152 個根目錄測試檔**同步歸位，其中 146 個對應這批題解，6 個對應原本已有 package 的題解。目前所有主程式與測試 Java 檔都有與路徑一致的 package。

分類依據是題目需要維護的狀態、關鍵推導與決策方式。每個檔案選一個主要考點，輔助技巧另外記錄，因此統計不會重複。下表以原本的 162 個題解檔案計數，`Q1523.java` 與 `Q1523_WA.java` 分開計入，不代表整個 repo 的題目總數；分類也不等同 LeetCode 官方標籤。

表中的「骨架」表示尚未實作；「待修」記錄閱讀時可指出的具體問題；「可改用」表示替代或進階練習方向。搬移時保留各版本的解題邏輯，僅調整 package 與必要的類別名稱；已通過全量主程式與測試編譯，尚未執行全專案測試斷言。

## 先分清楚核心方法與輔助工具

| 檔案 | 主要分類 | 判斷理由 |
| --- | --- | --- |
| [Q3](SlidingWindow/Q3.java) | Sliding Window | 關鍵是維護無重複的連續視窗，HashMap 保存視窗頻率 |
| [Q1_FollowUp](HashTable/Q1_FollowUp.java) | HashTable | 關鍵是補數查找與消耗候選；Stack 用來保存同值的多個索引 |
| [Q3557](Greedy/Q3557.java) | Greedy | 關鍵是盡早結束一段合法區間，為後續留下空間；Map 保存候選起點 |
| [Q1244](OrderedMap/Q1244.java) | OrderedMap | 排行榜需要同時維護玩家分數與有序分數頻率；目前使用 HashMap 加 TreeMap |
| [Q973](Heap/Q973.java) | Heap／Top K | 核心是選出距離最小的 k 個點；目前使用排序，Heap 與 Quickselect 是替代方法 |
| [Q3479](SegmentTree/Q3479.java) | Segment Tree | 要在更新後持續找「最左邊且容量足夠」的籃子，需要保留位置順序及區間最大值 |

例如，`Q3` 的解法可描述為「Sliding Window 加 HashMap」，但主分類選 Sliding Window；`Q1_FollowUp` 則選 HashTable，因為換掉保存索引的 Stack，補數配對的核心仍然成立。

這批 162 個題解目前都沒有使用 `PriorityQueue`。下表的 Heap 分類代表適合練習的考點，不表示現有檔案已寫成 Heap。

## 分類總覽

下列主分類已對應至實際 package；「Heap／Top K」使用 `Heap`，「PrefixSum／Running Sum」使用 `PrefixSum`。本次新增了 12 個原本不存在的 package。

| 主分類 | 檔案數 | 核心能力 |
| --- | --- | --- |
| HashTable | 23 | 補數、頻率、正規化 key、歷史位置、分組計數 |
| Heap／Top K | 1 | 只保留最好的 k 個候選 |
| OrderedMap | 1 | 可更新的排序關係與多重集合 |
| SlidingWindow | 9 | 連續區間、邊界移動與視窗狀態 |
| TwoPointers | 8 | 相向／同步掃描與批次排除候選 |
| Stack | 3 | 配對、消除、尚未完成的狀態 |
| PrefixSum／Running Sum | 5 | 累積量、區間轉換與收支平衡 |
| Greedy | 19 | 證明局部選擇可保留最佳答案 |
| Sorting | 7 | 排序後的鄰接性、比較規則與正規化 |
| BitManipulation | 12 | 位元性質、mask、狀態壓縮與二進位運算 |
| DynamicProgramming | 2 | 狀態定義與遞推 |
| BackTracking | 1 | 搜尋樹、合法前綴與剪枝 |
| Recursion | 1 | 利用遞迴結構反推位置 |
| SegmentTree | 1 | 帶更新的區間摘要與位置查詢 |
| Matrix | 9 | 二維索引、走訪順序與行列摘要 |
| Geometry | 6 | 座標、距離、面積與幾何條件 |
| Math | 27 | 餘數、因數、數位、公式與構造證明 |
| ArrayScan | 12 | 連續段、有限狀態與單次掃描 |
| StringAlgorithms | 3 | 字串解析與匹配 |
| Simulation | 12 | 按規則更新狀態、處理事件與邊界 |
| **合計** | **162** | 每個檔案只歸入一個主分類 |

## HashTable

重點是定義 key 與 value。小值域可以改用陣列；單純存在性可以用 Set。參考 [HashMap Pattern](HashTable/README.md) 與 [Java 模板](HashTable/TEMPLATES.md)。

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q1_FollowUp](HashTable/Q1_FollowUp.java) | 補數配對，每個索引只能使用一次 | `value -> Stack<index>`；找到補數後消耗一個候選，空集合移除 |
| [Q166](HashTable/Q166.java) | 長除法的重複狀態，`remainder -> 輸出位置` | Math、循環偵測；**待修**：尚未在產生第一位小數前登記初始餘數，會延後循環括號起點 |
| [Q219](HashTable/Q219.java) | 同值最近索引與距離上限 | 每輪查詢後覆寫最新位置；也可練習固定範圍的 Set |
| [Q288](HashTable/Q288.java) | 縮寫正規化與不同原字串的唯一性 | `abbreviation -> Set<word>`；另有資料結構設計與重複輸入處理 |
| [Q961](HashTable/Q961.java) | 重複值辨識與頻率統計 | 目前使用頻率表；利用題目結構，也能在 Set 首次發現重複時結束 |
| [Q966](HashTable/Q966.java) | 多層正規化查詢與優先順序 | 精確字串 Set、忽略大小寫 Map、母音正規化 Map；`putIfAbsent` 保留最早候選 |
| [Q1010](HashTable/Q1010.java) | 餘數互補的 pair 計數 | 查歷史頻率再加入；餘數 0 在現有實作用 60 表示，也可統一存 0 |
| [Q1128](HashTable/Q1128.java) | 無序二元組的 canonical key | 先把骨牌兩端排序，再依 key 計數；舊頻率就是新增配對數 |
| [Q1497](HashTable/Q1497.java) | 餘數分組能否完全兩兩配對 | 負餘數正規化、互補頻率相等；餘數 0 與偶數 k 的 k/2 都是自配組 |
| [Q1935](HashTable/Q1935.java) | 字元可用性查詢與單字有效性 | Set 保存壞鍵；掃描空白時結算一個單字，末尾另結算 |
| [Q2001](HashTable/Q2001.java) | 相同比例的正規化與分組配對 | 現用 double 轉 BigDecimal 作 key；可改成以 GCD 約分的整數比值 |
| [Q2154](HashTable/Q2154.java) | 存在性查詢驅動狀態轉移 | Set 查找目前值，存在就倍增；可用 `while (set.contains(original))` 直接表達停止條件 |
| [Q2260](HashTable/Q2260.java) | 同值最近位置形成的最短區間 | **待修**：更新式使用 `min(i, 距離)`，應保留先前最小答案；區間長度包含兩端 |
| [Q2506](HashTable/Q2506.java) | 「出現過哪些字元」的 signature | 目前 TreeSet 去重並排序成字串，再以 Map 計數；可用 26-bit mask |
| [Q2657](HashTable/Q2657.java) | 同步增長的兩個集合之交集數 | 兩個 Set 增量更新；題目中的 prefix 指前段集合，不是區間相消的 Prefix Sum |
| [Q2815](HashTable/Q2815.java) | `最大數位 -> 同組最佳數值` | **待修**：目前存最後一個數，應保存同組最大值，才能找到最大 pair sum |
| [Q3005](HashTable/Q3005.java) | 最高頻率與所有最高頻率元素的總出現數 | 先建頻率表，再找最大頻率並加總符合者 |
| [Q3120](HashTable/Q3120.java) | 大小寫兩種狀態的共同存在性 | Set 或兩個固定字母表旗標；只需要存在性 |
| [Q3121](HashTable/Q3121.java) | 每個字母的最後小寫位置與最早大寫位置 | 目前使用 `lastIndexOf`、`indexOf`；也可用兩個索引陣列，不是只看兩者有沒有出現 |
| [Q3471](HashTable/Q3471.java) | 計算值出現於幾個視窗，而非總頻率 | 視窗內 Set 去重、跨視窗 Map 計數；**待修**：迴圈漏掉最後一個長度 k 的視窗 |
| [Q3541](HashTable/Q3541.java) | 字元頻率加分類極值 | 母音、子音各自的最大頻率；固定字母表可用計數陣列 |
| [Q3591](HashTable/Q3591.java) | 對頻率值做質數判斷 | HashMap 計數加 Math 因數檢查，質數測試的對象是頻率 |
| [Q3623](HashTable/Q3623.java) | 依 y 座標分組，再計算不同組的水平邊組合 | **骨架**；依[題意](https://leetcode.com/problems/count-number-of-trapezoids-i/)可推導每組有 C(c,2) 條邊，再累加跨組乘積，搭配模數運算 |

## Heap 與 Top K

參考 [Heap Pattern](Heap/README.md)。單次取得全域最大值通常掃描即可；需要持續維護 k 個最佳候選時，才值得引入 Heap。

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q973](Heap/Q973.java) | K 個最近點的選取 | 目前排序平方距離，時間 `O(n log n)`；可練習大小 k 的 Max Heap，時間 `O(n log(k + 1))`，或 Quickselect |

## OrderedMap

`Q1244` 已放入 `OrderedMap`，練習有序查詢與資料結構設計，輔助技巧包含 HashMap／TreeMap。

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q1244](OrderedMap/Q1244.java) | 可更新排行榜的多重集合 | `playerId -> score` 與反向排序的 `score -> frequency` 同步維護；加分、reset 都要扣除舊頻率並加入新頻率 |

## SlidingWindow

核心是維護「目前這段連續區間」的條件，HashMap、Set 或整數計數器都可以作為視窗狀態。

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q3](SlidingWindow/Q3.java) | 最長不重複子字串 | 字元頻率 Map；出現重複就移動左界，直到視窗有效 |
| [Q1004](SlidingWindow/Q1004.java) | 至多 k 個零的最長視窗 | 目前為不縮短視窗長度的單步左移版本；與 `while` 恢復合法視窗的模板需分清 invariant |
| [Q1234](SlidingWindow/Q1234.java) | 用視窗外頻率判斷區間能否被替換 | **待修**：Q/W/E/R 沒有全部初始化，直接 `get` 拆箱可能出錯；外部各字元數量都不超額才能收縮 |
| [Q1461](SlidingWindow/Q1461.java) | 固定長度二進位子字串的覆蓋率 | 目前逐視窗擷取字串並用 Set 去重；可用 rolling bitmask 降低 key 建立成本 |
| [Q1984](SlidingWindow/Q1984.java) | 排序後的固定長度 k 視窗 | 關鍵是證明最小 max-min 可由排序後相鄰 k 個值取得，再掃描端點差 |
| [Q2302](SlidingWindow/Q2302.java) | 計數滿足 sum × length < k 的連續區間 | 正數帶來單調性；每個右端貢獻有效視窗長度，sum 與答案用 long |
| [Q2730](SlidingWindow/Q2730.java) | 至多一組相鄰相同字元的最長視窗 | 維護的是相鄰「邊」的重複數，不是每個字元的頻率 |
| [Q2958](SlidingWindow/Q2958.java) | 每個值頻率不超過 k 的最長視窗 | HashMap 保存視窗頻率；加入右端後只需針對超額的值收縮 |
| [Q2962](SlidingWindow/Q2962.java) | 全域最大值至少出現 k 次的區間計數 | 左界縮到不足 k 次後，合法起點共有 `left` 個；與累加視窗長度的版本不同 |

## TwoPointers

參考 [Two Pointers Pattern](TwoPointers/README.md)。重點是為每次移動證明「跳過的候選不會再需要」。

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q161](TwoPointers/Q161_Practice.java) | 兩字串首次分歧後的插入／刪除／替換 | **待修**：等長替換分支只跳過 s 的字元，t 也應跳過對應字元 |
| [Q167](TwoPointers/Q167_Practice.java) | 已排序陣列的相向補數查找 | 和太大右移、和太小左移；輸出為 1-based 索引 |
| [Q186](TwoPointers/Q186.java) | 原地反轉整段，再反轉每個單字 | 區間反轉的相向指標；空白切段與最後一個單字邊界 |
| [Q259](TwoPointers/Q259.java) | 固定一個值後的雙指標 triplet 計數 | 排序；一旦總和小於 target，一次新增 `right - left` 組 |
| [Q2105](TwoPointers/Q2105_Unfinished.java) | 兩端同步澆水與剩餘容量 | **骨架**；雙指標加模擬，交會的單一植物要獨立處理；已有[分類版本](TwoPointers/Q2105.java) |
| [Q2441](TwoPointers/Q2441.java) | 正負成對的最大絕對值 | 目前排序後相向查找；也可用 Set；**待修**：無解回傳值應為 -1，現為 0 |
| [Q2540](TwoPointers/Q2540_HashSet.java) | 兩個已排序陣列的最小共同值 | 目前使用 HashSet；可改同步雙指標以省空間，已有[分類版本](TwoPointers/Q2540.java) |
| [Q2824](TwoPointers/Q2824_Practice.java) | 小於 target 的 pair 批次計數 | 排序後若兩端和夠小，一次加入 `right - left`；已有[分類版本](TwoPointers/Q2824.java) |

## Stack

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q32](Stack/Q32.java) | 最長合法括號的邊界狀態 | 目前枚舉所有子字串並以 Stack 驗證，時間 `O(n³)`；核心練習可改為索引 Stack 或 DP |
| [Q1047](Stack/Q1047.java) | 相鄰相同字元的連鎖消除 | 用 Stack 保存尚未被消除的字元；**待修**：全部消除後應回傳空字串，現為 null |
| [Q2211](Stack/Q2211.java) | 碰撞連鎖與尚未結算的向右車輛 | 目前 Stack 模擬；也可推導移除外逃前綴 L、後綴 R 後，計數中間非 S 車輛 |

## PrefixSum 與 Running Sum

參考 [Prefix Sum Pattern](PrefixSum/README.md)。Running Sum 是累積狀態；只有需要區間相消時才必須建立完整 prefix array。

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q1732](PrefixSum/Q1732.java) | 累積高度與歷史最大值 | Running Sum，起始高度 0 也必須算入候選；無須 prefix array |
| [Q2574](PrefixSum/Q2574.java) | 每個位置左右兩側總和 | 目前 prefix／suffix 陣列；可改用 total sum 與 running left sum |
| [Q3427](PrefixSum/Q3427PrefixSum.java) | 不同左界的連續區間和 | `prefix[i + 1] - prefix[max(0, i - nums[i])]`；已有[分類版本](PrefixSum/Q3427.java) |
| [Q3432](PrefixSum/Q3432.java) | 分割後左右和的奇偶性 | 目前掃描左右總和；還可由 `left - right = 2 × left - total` 化簡成總和奇偶性 |
| [Q3737](PrefixSum/Q3737.java) | 將已知 target 的多數條件轉成正負平衡 | target 記 +1、其他記 -1；目前從每個起點累積並計數正和區間，不需 Boyer–Moore |

## Greedy

排序、HashMap 或 Two Pointers 常是工具；這組題目最需要練習的是「為什麼這個選擇不會使後面變差」。

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q280](Greedy/Q280.java) | 相鄰大小條件的局部修正 | 目前排序後交換相鄰位置；可練習單次掃描，只修正當前違反的大小關係 |
| [Q624](Greedy/Q624.java) | 跨陣列最大距離的歷史極值 | 使用當前陣列前先與歷史 min/max 配對，再更新極值，保證來自不同陣列 |
| [Q954](Greedy/Q954.java) | 倍數配對的處理順序與消耗頻率 | 可按絕對值由小到大配對 x、2x；**待修**：目前負奇數直接除以 2，整數截斷會製造錯誤配對 |
| [Q976](Greedy/Q976.java) | 最大周長三角形的排序貪心 | 從最大三個相鄰候選往下找；以三角不等式排除不可能的最大邊 |
| [Q1323](Greedy/Q1323.java) | 位權決定最佳修改位置 | 將最高位的第一個 6 改成 9，增益最大 |
| [Q1403](Greedy/Q1403.java) | 用最少元素取得超過一半的總和 | 降序取最大值直到跨越門檻；排序加累積 |
| [Q1561](Greedy/Q1561.java) | 三人分堆的最優分配 | 排序後把最小值留給第三人，自己取得其餘候選中的次大值 |
| [Q1874](Greedy/Q1874.java) | 乘積和最小化的反向配對 | 一組升序、另一組降序；核心是交換論證／重排不等式 |
| [Q1877](Greedy/Q1877.java) | 最小化最大 pair sum | 排序後最小配最大；雙指標是執行方式，貪心配對理由才是關鍵 |
| [Q2078](Greedy/Q2078.java) | 最遠異色位置的端點性質 | 目前 `O(n²)` 枚舉；可證明至少有一端能取全陣列端點，再線性掃描 |
| [Q2144](Greedy/Q2144.java) | 讓免費項目的價值盡量大 | 降序每三個為一組，支付前兩個；排序建立合法免費關係 |
| [Q2561](Greedy/Q2561.java) | 交換成本的直接路徑與全域最小值中轉 | 頻率差、排序與 `min(直接成本, 2 × 全域最小值)`；**待修**：現有頻率統計漏掉 basket2，差額與排序步驟也未完成 |
| [Q2833](Greedy/Q2833.java) | 把自由選擇全部用於放大既有偏移 | `abs(固定淨位移) + 空白數`；不必枚舉每個空白的方向 |
| [Q3010](Greedy/Q3010.java) | 固定第一段成本，其餘挑最小起點 | 目前將第一個值之外排序取兩個最小值；可單次掃描保留兩個最小值 |
| [Q3074](Greedy/Q3074.java) | 以最少容器覆蓋需求量 | 先加總需求，再優先取最大容量；不需要維持動態 Heap |
| [Q3075](Greedy/Q3075.java) | 遞減收益下的選取順序 | 降序取值，第 i 次收益為 `max(0, value - i)` |
| [Q3557](Greedy/Q3557.java) | 最大不重疊區間數的最早結束策略 | 依[題意](https://leetcode.com/problems/find-maximum-number-of-non-intersecting-substrings/)，候選需同首尾字母且長度至少 4；Map 保存最早起點，選中後清空候選 |
| [Q3633](Greedy/Q3633.java) | 先完成第一類活動的時間越早越有利 | 取每類最早完成時間，分別評估陸地先、水上先；不用枚舉所有活動配對 |
| [Q3689](Greedy/Q3689.java) | 找可達到的全域上界並重複使用 | 每段值至多 globalMax-globalMin；題意允許重複選同一區間，因此整段可選 k 次 |

## Sorting

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q1200](Sorting/Q1200.java) | 排序後最小差只需檢查相鄰值 | 最小值改變時清空答案，相同時追加 |
| [Q1356](Sorting/Q1356.java) | 多欄位排序：bitCount，再比原值 | 目前 TreeMap 分組且每加入一次就重排列表；可用一次 comparator 排序或最後統一排序 |
| [Q2273](Sorting/Q2273.java) | anagram 的正規化與連續等價段消除 | 目前排序每個字串再比較相鄰 signature；不是對所有字串全域去重 |
| [Q2784](Sorting/Q2784.java) | 排序後與目標多重集合比對 | 驗證 1 到 n-1 各一次、n 兩次；亦可用頻率陣列 |
| [Q2785](Sorting/Q2785.java) | 只排序指定位置的元素 | 抽出母音、排序、依原位置回填；子音維持原位 |
| [Q3606](Sorting/Q3606.java) | 篩選後按類別優先序與字典序排序 | 目前四個類別列表分別排序；也可建立類別 rank 加 comparator |
| [Q3731](Sorting/Q3731.java) | 排序後掃描缺口並輸出缺值 | 同時維護下一個預期整數與輸入索引；時間還要計入輸出缺值數量 |

## BitManipulation

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q231](BitManipulation/Q231.java) | 2 的冪只有一個 set bit | 目前反覆除以 2；可練習正數判斷加清除最低 set bit 的公式 |
| [Q342](BitManipulation/Q342.java) | 4 的冪需符合 set bit 的位置條件 | 目前反覆除以 4；可延伸 2 的冪判斷與位元位置檢查 |
| [Q693](BitManipulation/Q693.java) | 二進位相鄰位元交替 | 目前轉字串掃描；可研究 n 與右移一位之 XOR 的性質 |
| [Q762](BitManipulation/Q762.java) | set bit 數量與小範圍質數集合 | `Integer.bitCount` 加質數查表；Set 是固定查表工具 |
| [Q869](BitManipulation/Q869.java) | 枚舉 2 的冪並比對數位多重集合 | 排序數位作 signature；**待修**：候選使用 `i << i`，應按合法範圍生成 `1 << i` |
| [Q898](BitManipulation/Q898.java) | 以目前位置結尾的 OR 狀態壓縮 | **骨架**；依[題意](https://leetcode.com/problems/bitwise-ors-of-subarrays/)保留上一輪 OR 集合，延伸後去重；OR 只會增加 set bits，使每輪不同狀態受位元數限制 |
| [Q1009](BitManipulation/Q1009.java) | 只反轉有效位元範圍 | 目前用二進位字串反轉字元；可用全 1 mask XOR，另處理 n=0 |
| [Q1404](BitManipulation/Q1404.java) | 二進位加一進位與右移除二 | 目前 BigInteger 模擬；可從右向左維護 carry 計算步數，避免反覆大整數運算 |
| [Q1680](BitManipulation/Q1680.java) | 二進位串接的位移與模數 | 目前求 bitLength 後乘 2 的冪；可在遇到 2 的冪時更新位數並使用左移 |
| [Q2419](BitManipulation/Q2419.java) | AND 的上界推出最大值連續段 | 對題目的非負數，AND 不超過任一元素；答案化為全域最大值的最長連續段 |
| [Q2438](BitManipulation/Q2438.java) | set bits 拆成 2 的冪，再查區間乘積 | 目前每次直接乘區間；可將乘積轉成指數和，再結合 Prefix Sum |
| [Q3370](BitManipulation/Q3370.java) | 下一個足夠大的全 1 位元數 | 目前用 `result = result * 2 + 1` 逐步生成 1、3、7、15… |

## DynamicProgramming

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q53](DynamicProgramming/Q53.java) | 以目前位置結尾的最大區間和 | **骨架**；可練習 Kadane，或 `目前 prefix - 歷史最小 prefix`；已有 [Prefix Sum 版本](PrefixSum/Q53PrefixSum.java) |
| [Q118](DynamicProgramming/Q118.java) | 上一層相鄰狀態產生下一層 | 目前遞迴建 Pascal Triangle；本質是局部遞推，亦可逐列迭代 |

## BackTracking

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q22](BackTracking/Q22.java) | 合法括號生成與前綴剪枝 | 目前枚舉所有 2n 位組合後再用 Stack 驗證；可在搜尋時維護 `右括號數 ≤ 左括號數 ≤ n`，直接剪去非法分支 |

## Recursion

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q1545](Recursion/Q1545.java) | 遞迴字串的鏡射與反轉關係 | 目前展開整個長度 `2^n - 1` 字串；可按 k 位於左半、中點或右半反推，不必建完整字串 |

## SegmentTree

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q3479](SegmentTree/Q3479.java) | 找最左側容量足夠且尚未使用的位置 | 目前 `O(n²)` 掃描；[題目 n 可達 10^5](https://leetcode.com/problems/fruits-into-baskets-iii/)，可用存區間 max 的 Segment Tree，左側優先下降並單點更新，總計 `O(n log n)` |

這裡若把 baskets 直接按容量排序，會破壞「最左側」的規則。Segment Tree 每個節點的 max 用來判斷該區間是否存在候選，再優先檢查左半，才能同時符合容量與索引條件。

## Matrix

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q311](Matrix/Q311.java) | 矩陣乘法與稀疏性剪枝 | 目前跳過 mat1 為 0 的乘加；可再用非零位置列表壓縮資料 |
| [Q422](Matrix/Q422.java) | 不規則字串矩陣的對稱位置驗證 | 檢查 `words[i][j] == words[j][i]`；**待修**：索引對調前缺少行數與字串長度檢查 |
| [Q498](Matrix/Q498.java) | 對角線分組與交替方向 | 目前以 i+j 作 TreeMap key；可直接按對角線順序模擬，Map 是分組工具 |
| [Q766](Matrix/Q766.java) | 相鄰對角元素相等的局部檢查 | 比較每格與左上格，將整條對角線條件化成相鄰關係 |
| [Q840](Matrix/Q840.java) | 固定 3×3 區塊的多重限制驗證 | **待修**：掃描邊界漏掉有效區塊，兩條對角線總和尚未計算；另需唯一性與行列和 |
| [Q867](Matrix/Q867.java) | 行列維度交換與座標映射 | `result[col][row] = matrix[row][col]`，非方陣的輸出形狀也要正確 |
| [Q944](Matrix/Q944.java) | 逐欄比較相鄰列的排序關係 | 一欄只要出現一次逆序就計數並停止檢查該欄 |
| [Q1582](Matrix/Q1582.java) | 每行每列唯一的 1 | 目前對每個 1 重掃行列；可預先統計 rowCount、colCount，降為兩次矩陣掃描 |
| [Q3531](Matrix/Q3531.java) | 行列各方向的存在性轉成 min/max | **待修**：min 陣列初始值不合適，rowMax 又使用 Math.min；值域大時可用 Map 保存每行／列極值 |

## Geometry

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q812](Geometry/Q812.java) | 座標三角形面積與三點枚舉 | 行列式／叉積公式，取絕對值再除以 2 |
| [Q836](Geometry/Q836.java) | 兩軸上的投影都需正長度重疊 | **待修**：目前只比較單方向的右上與左下，沒有完整檢查兩個矩形的交集 |
| [Q1266](Geometry/Q1266.java) | 可斜走時的兩點最短步數 | 每段為 `max(abs(dx), abs(dy))`，再依指定順序加總 |
| [Q1344](Geometry/Q1344.java) | 時鐘角度與連續位移 | 時針每分鐘也移動 0.5 度；最後取圓周上的較小夾角 |
| [Q3000](Geometry/Q3000.java) | 依對角線，再依面積比較 | 平方長度即可比較對角線，無須開根號；注意相同主條件的 tie-break |
| [Q3024](Geometry/Q3024.java) | 三角不等式與邊長相等關係 | 排序後先驗證能形成三角形，再判斷等邊、等腰與不等邊 |

## Math

這組主要練習數值性質與推導。即使實作用迴圈、字串或 Set，通常仍應先掌握公式、數位分解或構造理由。

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q326](Math/Q326.java) | 3 的冪的整除性 | 反覆除以 3，最後是否剩 1；先排除非正數 |
| [Q788](Math/Q788.java) | 每個數位旋轉後是否有效且至少改變一位 | 枚舉數字加數位分類；兩種條件必須分開維護 |
| [Q1056](Math/Q1056.java) | 數位旋轉映射與整數反轉 | Map 是固定查表；另需確認反轉後是否不同於原數，已有 [HashTable 版本](HashTable/Q1056.java) |
| [Q1134](Math/Q1134.java) | 數位冪次和 | 取得位數，累加每個 digit 的該次方，再與原數比較 |
| [Q1228](Math/Q1228.java) | 等差數列缺項的公差推導 | 用首尾差除以目前長度；目前線性找缺口，也可練習二分第一個不符預期值的位置 |
| [Q1295](Math/Q1295.java) | 十進位位數的奇偶性 | 目前轉字串取長度，也可反覆除以 10 |
| [Q1304](Math/Q1304.java) | 成對正負數的零和構造 | 建立 ±1、±2…，奇數長度另放 0；核心是構造與唯一性 |
| [Q1317](Math/Q1317.java) | 枚舉一個加數，另一個由 n-a 決定 | 數位合法性檢查；不需用 HashMap 做 Two Sum |
| [Q1390](Math/Q1390.java) | 因數成對出現與平方根界線 | 枚舉到 sqrt(n)，完全平方數的中間因數不能重複計入 |
| [Q1523](Math/Q1523.java) | 區間奇數個數的端點公式 | 使用區間長度與端點奇偶性，時間 `O(1)` |
| [Q1523_WA](Math/Q1523_WA.java) | 同題的逐數枚舉基線 | 檔名標記 WA；目前 `O(high-low+1)` 掃描，可與公式版比較效率，不能僅憑檔名判定錯誤原因 |
| [Q1894](Math/Q1894.java) | 重複週期先取餘數，再定位週期內位置 | `k %= total` 後順序扣除；多次查詢時可加 Prefix Sum 與 Binary Search |
| [Q1925](Math/Q1925.java) | 平方和與完全平方數驗證 | 枚舉 a、b，推導 c；有序的 (a,b) 與 (b,a) 需依題意分別計數 |
| [Q1952](Math/Q1952.java) | 恰有三個正因數等價於質數的平方 | 目前逐數找因數；可先驗證完全平方數，再檢查平方根是否為質數 |
| [Q1979](Math/Q1979.java) | 極值掃描與歐幾里得算法 | 先找最小、最大值，再遞迴 `gcd(y, x % y)` |
| [Q1980](Math/Q1980.java) | 缺失字串的存在性與構造 | 目前 Set 加鴿籠原理：n 個輸入無法覆蓋 0..n；也可練習逐位翻轉第 i 個字串第 i 位的對角線構造 |
| [Q2469](Math/Q2469.java) | 公式代入與浮點計算 | 溫標轉換，沒有額外資料結構需求 |
| [Q2553](Math/Q2553.java) | 數位拆解後維持原順序 | `% 10` 取得的是反向數位，需再反向輸出；另有[競賽版本](BiWeeklyContest97/Q2553.java) |
| [Q3190](Math/Q3190.java) | 對 3 的餘數與最小調整次數 | 不可被 3 整除的整數，只需加一或減一，因此直接計數 |
| [Q3512](Math/Q3512.java) | 總和對 k 的餘數 | 每次總和減一，最少操作數為 `sum % k` |
| [Q3516](Math/Q3516.java) | 一維距離比較 | 比較兩個絕對距離，另處理相同距離 |
| [Q3550](Math/Q3550.java) | 數位和與索引的條件比對 | 逐位 `% 10`、`/ 10`；找到第一個符合位置即可停止 |
| [Q3622](Math/Q3622.java) | 數位和、數位積與整除性 | 分別累積兩者，再檢查 n 是否可被其和整除 |
| [Q3658](Math/Q3658.java) | 等差級數與 GCD 化簡 | 目前計算 gcd(n²,n(n+1))；利用 gcd(n,n+1)=1 可直接得到 n |
| [Q3754](Math/Q3754.java) | 去除零數位、重組整數與數位和 | 維持原數位順序，再計算乘積；中間結果與答案使用 long |
| [Q3783](Math/Q3783.java) | 整數數位反轉與距離 | 目前轉字串反轉，再取差的絕對值 |
| [Q3876](Math/Q3876.java) | 最小元素限制與奇偶構造 | 最小值若為奇數，可使所有數為奇數；若最小值為偶數，需原本全為偶數；要能說明必要與充分性 |

## ArrayScan

`ArrayScan` 收錄連續段與有限狀態的掃描題。這些題目最重要的是「掃描到這裡，手上的狀態代表什麼」。

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q1180](ArrayScan/Q1180.java) | 相同字元連續段的區間計數 | 每段長度 L 貢獻 L(L+1)/2；另一寫法逐位置累加目前連續長度 |
| [Q1758](ArrayScan/Q1758.java) | 兩種交替字串模板的錯位計數 | **骨架**；依[題意](https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/)只需比較 0101… 與 1010…，不是可移動字元的配對題 |
| [Q1784](ArrayScan/Q1784.java) | 1 區段是否已經結束的狀態 | 題目的二進位表示無前導零，因此出現 01 代表第二段 1；若放寬此前提需調整判斷 |
| [Q1848](ArrayScan/Q1848.java) | 符合指定值的最近索引 | 直接掃描並維護最小絕對距離；不需要反覆建立 map |
| [Q2161](ArrayScan/Q2161.java) | 相對順序不變的三路分組 | 目前三次掃描依序輸出小於、等於、大於 pivot；穩定性是考點 |
| [Q2210](ArrayScan/Q2210.java) | 壓縮相同值區段後判斷局部極值 | 先去除相鄰重複，再比較前、中、後三值 |
| [Q2264](ArrayScan/Q2264.java) | 固定三字元條件與最佳值 | 目前 Set 保存符合者再取最大；一次掃描保留最大 digit 即可 |
| [Q3151](ArrayScan/Q3151.java) | 相鄰元素的奇偶交替 | 逐對驗證；不需要 prefix，除非延伸到多區間查詢 |
| [Q3330](ArrayScan/Q3330.java) | 連續重複段可縮短的選擇數 | 每段長度 L 多出 L-1 種選擇，再加完全不縮短的 1 種 |
| [Q3350](ArrayScan/Q3350.java) | 兩個相鄰遞增段的長度關係 | **待修**：i=0 時讀取 i-1，且答案尚未完整推導；應比較同段拆半與相鄰兩段較短長度 |
| [Q3637](ArrayScan/Q3637.java) | 嚴格遞增、遞減、再遞增的三階段狀態 | 第一個方法逐段消耗；第二個方法 `isTrionic1` **待修**：缺少完整走到陣列末尾的確認 |
| [Q3683](ArrayScan/Q3683.java) | 每個任務獨立計算完成時間，再取最小值 | 單次掃描 `min(start + duration)`；沒有持續排程的 Heap 狀態 |

## StringAlgorithms

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q165](StringAlgorithms/Q165.java) | 分段解析、前導零與缺失段補零 | 分割版本號並逐段比較；需要的是數值大小而非整串字典序 |
| [Q796](StringAlgorithms/Q796.java) | 旋轉關係轉成倍長字串的子字串匹配 | 長度相同且 goal 存在於 s+s；匹配演算法可再延伸 KMP |
| [Q1967](StringAlgorithms/Q1967.java) | 多個 pattern 的存在性匹配 | 目前逐一呼叫字串搜尋；每個 pattern 最多貢獻一次，重複輸入仍按項目計數 |

## Simulation

核心是正確實現每一步規則。先寫清楚每個變數代表操作前還是操作後的狀態。

| 檔案 | 實際考點 | 目前實作與輔助技巧 |
| --- | --- | --- |
| [Q66](Simulation/Q66.java) | 由低位往高位傳遞進位 | 遇到非 9 即停止；全為 9 時需增加一位 |
| [Q412](Simulation/Q412.java) | 多條件輸出的優先順序 | 同時整除 3 與 5 的情況先處理 |
| [Q1518](Simulation/Q1518.java) | 空瓶交換與餘數保存 | 一輪交換後的新空瓶加上未用掉的舊空瓶，再進入下一輪 |
| [Q1716](Simulation/Q1716.java) | 每週與每天的雙層增量 | 目前按週模擬；可再用等差級數處理完整週與剩餘天數 |
| [Q2011](Simulation/Q2011.java) | 指令解析與單一狀態更新 | 依每個字串操作增減數值 |
| [Q3069](Simulation/Q3069.java) | 逐元素比較兩個結果陣列尾端後分派 | **待修**：目前多數元素依索引奇偶分派，只在最後一次比較尾端，未遵守逐次規則 |
| [Q3100](Simulation/Q3100.java) | 交換需求會變動的空瓶模擬 | 每換一次後提高需求；不能直接套固定匯率的批次除法 |
| [Q3433](Simulation/Q3433.java) | 事件排序、同時間優先序與在線狀態 | **骨架**；[題意](https://leetcode.com/problems/count-mentions-per-user/)要求同時間先處理狀態變更，再處理訊息；可保存每位使用者重新上線時間 |
| [Q3461](Simulation/Q3461.java) | 逐輪相鄰數字合成 | 每輪以新字串承接模 10 結果，直到剩兩位；目前 `O(n²)` 模擬 |
| [Q3477](Simulation/Q3477.java) | 按原位置找第一個可用籃子並消耗 | 雙迴圈直接模擬；可與 Q3479 的資料結構優化對照 |
| [Q3507](Simulation/Q3507.java) | 每輪選最小相鄰和、合併並重查順序 | 目前 ArrayList 模擬；相同最小和保留最左者。更大規模才需額外考慮 Heap 與鄰接關係更新 |
| [Q3612](Simulation/Q3612.java) | 依序處理刪尾、複製與反轉 | StringBuilder 模擬；刪尾類似 Stack，但還有整串複製與反轉，成本需計入中間字串長度 |

## 優先複習與整理順序

1. **先建立可轉移的模板**：Q219 的最新索引、Q1_FollowUp 的可消耗配對、Q3 的視窗頻率、Q167 的相向指標、Q1047 的相鄰消除。
2. **練習區分考點與工具**：比較 Q3／Q219、Q22／Q32、Q973／Q1244、Q3477／Q3479。
3. **先處理骨架再當作範例**：Q53、Q898、Q1758、Q2105、Q3433、Q3623 共 6 個檔案尚未完成。
4. **把具體錯誤連回 invariant**：Q2815 要保存歷史最大值，Q2260 要保存歷史最小答案，Q1234 要完整定義所有字元頻率。這些問題適合作為 Pattern 邊界練習。
5. **比較同題的不同版本**：Q53、Q161、Q167、Q1056、Q2105、Q2540、Q2553、Q2824、Q3427 保留了不同練習或分類版本；閱讀時確認測試對應哪個類別。

分類的驗收方式是：能否在不看 import 的情況下，說出每題維護什麼狀態、每一步為什麼正確，以及換掉輔助資料結構後，核心解法是否仍相同。

## 搬移與編譯紀錄

目標 package 已有同名類別時，保留既有類別，將原根目錄版本改名如下。測試引用也跟著改名，確保仍測試原本的實作。

| 原根目錄類別 | 搬移後類別 | 對應的原根目錄測試 |
| --- | --- | --- |
| Q161 | [TwoPointers.Q161_Practice](TwoPointers/Q161_Practice.java) | [Q161_Practice_test](../../test/java/TwoPointers/Q161_Practice_test.java) |
| Q167 | [TwoPointers.Q167_Practice](TwoPointers/Q167_Practice.java) | [Q167_Practice_test](../../test/java/TwoPointers/Q167_Practice_test.java) |
| Q2105 | [TwoPointers.Q2105_Unfinished](TwoPointers/Q2105_Unfinished.java) | 原骨架沒有根目錄測試；既有 Q2105 測試仍對應原本的完整版本 |
| Q2540 | [TwoPointers.Q2540_HashSet](TwoPointers/Q2540_HashSet.java) | [Q2540_HashSet_test](../../test/java/TwoPointers/Q2540_HashSet_test.java) |
| Q2824 | [TwoPointers.Q2824_Practice](TwoPointers/Q2824_Practice.java) | [Q2824_Practice_test](../../test/java/TwoPointers/Q2824_Practice_test.java) |
| Q3427 | [PrefixSum.Q3427PrefixSum](PrefixSum/Q3427PrefixSum.java) | 原根目錄版本沒有獨立測試；既有 PrefixSum.Q3427_test 保留原引用 |

另外歸位的 6 個測試為：Blind75 的 Q21、Q141、Q206，Tree 的 Q1448、Q2476，以及 TwoPointers 的 Q923。現有分類內的其他題解與測試保持原版本。

編譯驗證使用 Java 17 相容設定：

- Maven Compiler Plugin 3.15.0 的 `compile` 與 `testCompile`：成功。
- 全新輸出目錄中的 `javac --release 17`：391 個主程式檔、340 個測試檔全量編譯成功。
- 所有 Java 檔的 package、檔案路徑與 public class 名稱一致；搬移的 314 個檔案已比對原始內容，確認解題邏輯與測試斷言未變。

若 Maven 已在 PATH，可重現本次使用的編譯目標：

```bash
mvn -Dmaven.compiler.release=17 org.apache.maven.plugins:maven-compiler-plugin:3.15.0:compile org.apache.maven.plugins:maven-compiler-plugin:3.15.0:testCompile
```

本次使用 IntelliJ IDEA 附帶的 Maven。離線執行 `clean test-compile` 時，clean plugin 的相依套件快取不完整，因此改用已快取的 Compiler Plugin 直接編譯，並以獨立的全量 javac 編譯排除舊 class 檔的影響。
