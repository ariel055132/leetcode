public class Q2419 {
    // Find the longest subarray where all elements are equal to the maximum element in the array
    // Iterate through the array and keep track of consecutive occurrences of the maximum value
    public int longestSubArray(int[] nums) {
        int maxLength = 0;
        int currentLength = 0;
        int maxValue = Integer.MIN_VALUE;
        // Find the maximum values in the array
        for (int num : nums) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        // Iterate through the array and count the length of consecutive element equals to maximum Value
        for (int num : nums) {
            if (num == maxValue) {
                currentLength++;
                // Keep Updating the maximum length
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 0;
            }
        }

        return maxLength;
    }
}
