public class Q3151 {
    /**
     * An array is considered special if the parity of every pair of adjacent elements is different. In other words, one element in each pair must be even, and the other must be odd.
     * You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.
     * 
     * @param nums
     * @return
     */
    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // Compare the parity of adjacent elements in nums
            if (nums[i] % 2 == nums[i - 1] % 2) {
                return false;
            }
        }
        return true;
    }
}
