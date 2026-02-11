package BiWeeklyContest100;

import java.util.Arrays;

public class Q2592 {
    /**
     * 1, 3, 5, 2, 1, 3, 1
     * 0  1  2  3  4  5  6
     *
     * 1  1  1  2  3  3  5
     * *
     */
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                result++;
                i++;
            }
        }
        return result;
    }
}
