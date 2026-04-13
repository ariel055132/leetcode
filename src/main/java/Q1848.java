public class Q1848 {
    /**
     * Given an integer array nums (0-indexed) and two integers target and start, find an index i such that nums[i] == target and abs(i - start) is minimized. Note that abs(x) is the absolute value of x.
     * Return abs(i - start).
     * It is guaranteed that target exists in nums.
     * 
     * Just follow the question and code.
     * 
     * @param nums
     * @param target
     * @param start
     * @return
     */
    public int getMinDistance(int[] nums, int target, int start) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result = Math.abs(Math.min(result, i - start));
            }
        }
        return result;
    }
    
}
