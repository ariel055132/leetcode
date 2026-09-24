public class Q3550 {
    /**
     * You are given an integer array nums.
     * Return the smallest index i such that the sum of the digits of nums[i] is equal to i.
     * If no such index exists, return -1.
     * 
     * Find the smallest index i where the digit sum of nums[i] equal i.
     * If no index matches, returns -1
     * 
     * Check each number, calculating its digit sum using % 10 and / 10
     * 
     * @param nums
     * @return
     */
    public int smallestIndex(int[] nums) {
        // Marker meaning no match found
        int result = Integer.MAX_VALUE;
        // Traverse the array nums
        for (int i = 0; i < nums.length; i++) {
            // Copy nums[i] into num, so the original array stays unchanged
            int num = nums[i];
            // Calculate the digit sum
            int digitSum = 0;
            while (num != 0) {
                digitSum += num % 10; // Extract the last digit
                num /= 10; // remove the last digit
            }
            // If digitSum == i, update the smallest matching index
            if (digitSum == i) {
                result = Math.min(result, digitSum);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
