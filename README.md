# LeetCode 練習與解題筆記

以 **Java** 記錄 LeetCode 解題練習，搭配 **JUnit 5** 測試驗證範例與邊界條件。內容涵蓋依演算法與資料結構分類的題解、Blind 75、週賽與雙週賽練習，以及可供複習的 Pattern 筆記。

同一道題可能保留暴力法、不同演算法或後續練習版本，方便比較思路與時間、空間複雜度。這是一份持續累積的學習紀錄，部分檔案包含錯誤嘗試或尚待完善的解法。

## 快速導覽

- [依主題找題解](#題解分類)
- [閱讀筆記](#解題筆記)
- [設定環境與執行測試](#環境與執行方式)
- [了解檔名慣例](#檔名慣例)
- [新增練習](#新增練習)

## 專案結構

```text
leetcode/
├── pom.xml                     # Maven 設定與 JUnit 相依套件
├── src/
│   ├── main/java/
│   │   ├── Q<number>.java      # 直接放在根目錄的題解
│   │   ├── BinarySearch/       # 依演算法、資料結構分類
│   │   ├── PrefixSum/
│   │   │   └── README.md       # Prefix Sum Pattern 筆記
│   │   ├── …
│   │   ├── Blind75/            # Blind 75 題單練習
│   │   ├── Quests/             # Quests 練習
│   │   ├── WeeklyContest*/     # 週賽練習（另有 Contest468/）
│   │   ├── BiWeeklyContest*/   # 雙週賽練習
│   │   └── Code.md             # 常用程式片段與資料結構筆記
│   └── test/java/             # JUnit 測試，多數對應題解分類
└── .codex/skills/              # 題目解說與 Pattern 筆記輔助技能
```

## 題解分類

| 主題 | 目錄 |
| --- | --- |
| 二分搜尋 | [BinarySearch](src/main/java/BinarySearch/) |
| 雙指標 | [TwoPointers](src/main/java/TwoPointers/) |
| 滑動視窗 | [SlidingWindow](src/main/java/SlidingWindow/) |
| 前綴和 | [PrefixSum](src/main/java/PrefixSum/) |
| 雜湊表 | [HashTable](src/main/java/HashTable/) |
| 堆疊 | [Stack](src/main/java/Stack/) |
| 佇列 | [Queue](src/main/java/Queue/) |
| 堆積／優先佇列 | [Heap](src/main/java/Heap/) |
| 鏈結串列 | [LinkedList](src/main/java/LinkedList/) |
| 樹 | [Tree](src/main/java/Tree/) |
| 圖 | [Graph](src/main/java/Graph/) |
| 字典樹 | [Trie](src/main/java/Trie/) |
| 回溯 | [BackTracking](src/main/java/BackTracking/) |
| 位元運算 | [BitManipulation](src/main/java/BitManipulation/) |

其他練習入口：

- [Blind 75](src/main/java/Blind75/)：目前已收錄的題單練習。
- [Quests](src/main/java/Quests/)：以 `Q1`、`Q2` 等檔名整理的練習。
- [所有題解與競賽目錄](src/main/java/)：包含未放入主題分類的題解，以及 `WeeklyContest*`、`BiWeeklyContest*`、`Contest468` 等競賽練習。
- [所有測試](src/test/java/)：查看輸入、預期結果與測試案例。

## 解題筆記

| 筆記 | 內容 |
| --- | --- |
| [Prefix Sum Pattern](src/main/java/PrefixSum/README.md) | 適用情境、辨識訊號、核心狀態、Java 模板、代表題目、常見錯誤與複習清單 |
| [Code 筆記](src/main/java/Code.md) | 矩陣轉置、二元搜尋樹走訪、Heap 與 Union-Find 等筆記及程式片段 |

可先從題解與測試理解單題，再透過 Pattern 筆記整理共通思路。例如，對照 [Q560 題解](src/main/java/PrefixSum/Q560PrefixSum.java) 與 Prefix Sum 筆記，理解如何結合前綴和與 HashMap 計算子陣列數量。

## 環境與執行方式

專案設定見 [pom.xml](pom.xml)：

- Java 編譯目標：**17**，請準備 JDK 17 或相容的較新版本。
- 建置工具：**Maven**，repo 未附 Maven Wrapper，使用命令列前需自行安裝。
- 測試框架：**JUnit Jupiter 5.10.0**。

### 使用 IDE

1. 以 IntelliJ IDEA 或支援 Java、Maven 的 IDE 開啟 repo 根目錄。
2. 匯入 `pom.xml` 並完成 Maven 相依套件同步，將 Project SDK 設為 JDK 17 或相容版本。
3. 開啟 `src/test/java` 中的測試類別，執行個別測試方法或整個類別。

例如，[Blind75/Q1_test.java](src/test/java/Blind75/Q1_test.java) 可用來測試 [Two Sum 題解](src/main/java/Blind75/Q1.java)。題解多以方法形式提供，透過測試呼叫即可。

### 使用 Maven

在 repo 根目錄確認環境並編譯題解：

```bash
java -version
mvn -version
mvn compile
```

目前 `pom.xml` 未指定 Maven Surefire Plugin 版本，且測試檔案多採用 `Q<number>_test.java` 命名。為避免預設插件版本或測試檔名篩選導致漏跑，以下指令明確指定支援 JUnit 5 的 Surefire 版本及測試類別篩選。

執行單一題目的測試：

```bash
mvn test-compile org.apache.maven.plugins:maven-surefire-plugin:3.2.5:test -Dtest=Blind75.Q1_test
```

執行以 `_test` 或 `Test` 結尾的測試類別：

```bash
mvn test-compile org.apache.maven.plugins:maven-surefire-plugin:3.2.5:test '-Dtest=*_test,*Test'
```

執行後可在 `target/surefire-reports/` 查看測試報告，並確認實際執行的測試數量。指定單一測試仍會先編譯整個專案的題解與測試，其他檔案若有編譯錯誤，也會阻擋執行。

> 上述 Maven 指令尚未在本次撰寫 README 的環境實際驗證，因該環境未安裝 Maven；目前不宣稱全專案測試皆通過。

## 檔名慣例

| 形式 | 說明與範例 |
| --- | --- |
| `Q<number>.java` | 一般以 LeetCode 題號命名，例如 `Blind75/Q1.java` |
| `Q<number>_test.java` | 對應題目的測試，例如 `Blind75/Q1_test.java`；部分測試以 `Test` 結尾 |
| 演算法後綴 | 區分不同解法，例如 `Q560PrefixSum.java`、`Q242_HashTable.java` |
| `_Brute`／`_BruteForce` | 暴力解法版本，方便理解起點或比較效率 |
| `_FollowUp`／`_Follow`／`_v2` | 延伸練習或另一個實作版本 |
| `_WA` | 標記錯誤嘗試的版本，閱讀時應配合測試與題意檢查 |

競賽與 Quests 目錄中的 `Q1`、`Q2` 等檔名也可能代表練習順序，不一定是 LeetCode 的正式題號。同一題可能出現在不同目錄，查找時可在 IDE 以檔名搜尋，例如 `Q560`。

## 新增練習

1. 在 `src/main/java` 選擇適合的主題或競賽目錄，新增題解，並讓 `package` 與目錄一致。
2. 在 `src/test/java` 對應位置新增 JUnit 5 測試，涵蓋題目範例與必要的邊界條件。
3. 在註解中記錄解題思路、時間與空間複雜度；若保留不同解法，使用清楚的後綴區分。
4. 執行相關測試，將可重用的思路與常見錯誤補入對應筆記。

樹與鏈結串列題目可參考既有的 [TreeNode](src/main/java/Tree/TreeNode.java)、[ListNode](src/main/java/LinkedList/ListNode.java)，以及測試中的 [BaseTreeTest](src/test/java/Tree/BaseTreeTest.java)、[BaseLinkedListTest](src/test/java/LinkedList/BaseLinkedListTest.java)。
