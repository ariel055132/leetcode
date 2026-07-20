public class Q3737 {
    /**
     * You are given an integer array nums and an integer target.
     * Return the number of of nums in which target is the majority element.
     * The majority element of a subarray is the element that appears strictly more than half of the times in that subarray.
     * 
     * Because the majority candidate is already given as target, we do not need a frequency map.
     * Transform each element into:
     * +1 when nums[i] == target
     * -1 otherwise
     * 
     * For any subarray:
     * count = number of targets - number of non-targets
     * The target is majority exactly when
     * count > 0
     * @param nums
     * @param target
     * @return
     */
    public int countMajoritySubarrays(int[] nums, int target) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) {
                    count++;
                } else if (nums[j] != target) {
                    count--;
                }
                if (count > 0) result++;
            }
        }


        return result;
    }
}
