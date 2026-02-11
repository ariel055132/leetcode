import java.util.List;

public class Q3350 {
    public int maxIncreasingSubArrays(List<Integer> nums) {
        int pre_up = 0;
        int now_up = 1;
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i-1)) {
                now_up++;
            } else {
                pre_up = now_up;
                now_up = 1;
            }
        }
        result = Math.max(pre_up, now_up);
        return result;
    }
}
