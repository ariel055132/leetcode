package Quests;

public class Q3 {
    // Given a binary number array, find the maximum number of consecutive ones.
    public int findMaxConsecutiveOnes(int[] nums) {
        int currentOnes = 0; // Counting the number of ones
        int result = 0; // Return result
        // Traverse the binary number array
        for (int num : nums) {
            // If num is 1, increment the currentOnes
            if (num == 1) {
                currentOnes++;
            } else {
                // If num is 0, figure out the maximum number of consecutive ones
                result = Math.max(result, currentOnes);
                // the counter should be reset to 0
                currentOnes = 0;
            }
        }
        result = Math.max(result, currentOnes);
        return result;
    }
}
