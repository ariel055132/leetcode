package Quests;

import java.util.ArrayList;
import java.util.List;

public class Q7 {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            result.add("Push");
            if (target[j] == i) {
                j++;
            } else {
                result.add("Pop");
            }
        }

        return result;
    }
}
