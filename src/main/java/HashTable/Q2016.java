package HashTable;

public class Q2016 {
    public int maximumDifference(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    result = Math.max(result, nums[j] - nums[i]);       
                }
            }
        }

        return result == Integer.MIN_VALUE ? -1 : result;
    }
}
