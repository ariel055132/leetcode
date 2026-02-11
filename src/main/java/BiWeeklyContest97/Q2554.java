package BiWeeklyContest97;

import java.util.HashSet;

public class Q2554 {
    public int maxCount(int[] banned, int n, int maxSum) {
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : banned) {
            set.add(num);
        }
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }
            if (i <= maxSum) {
                result++;
                System.out.println(i);
                maxSum -= i;
            } else {
                break;
            }
        }
        return result;
    }
}
