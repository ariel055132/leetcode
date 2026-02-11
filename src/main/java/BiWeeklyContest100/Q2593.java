package BiWeeklyContest100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2593 {
    public long findScore(int[] nums) {
        List<int[]> numsWithIndex = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numsWithIndex.add(new int[] {nums[i], i});
        }
        // Sort the array with value
        Collections.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));
        long result = 0;
        for (int i = 0; i < numsWithIndex.size(); i++) {
            int num = numsWithIndex.get(i)[0];
            int index = numsWithIndex.get(i)[1];
            if (nums[index] != -1) {
                result += num;
                nums[index] = -1;
                if (index > 0) {
                    nums[index - 1] = -1;
                }
                if (index < nums.length - 1) {
                    nums[index + 1] = -1;
                }
            }
        }
        return result;
    }
}
