package WeeklyContest506;

import java.util.HashMap;
import java.util.Map;

public class Q2 {
    /**
     * You are given an integer array ​​​​​​​nums.
     * Define a frequency balance subarray as follows:
     * If the subarray contains only one distinct value, it is frequency balanced.
     * Otherwise, there must exist a positive integer f such that every distinct value in the subarray occurs either f or 2 * f times, and both frequencies occur among the distinct values.
     * 
     * Return an integer denoting the length of the longest frequency balance subarray.
     * 
     * enumerate every subarray while maintaining enough information to check its frequencies in constant expected time.
     * 
     * @param nums
     * @return
     */
    public int getLength(int[] nums) {
        int result = 1;
        for (int left = 0; left < nums.length; left++) {
            // Value -> number of occurrences
            Map<Integer, Integer> freq = new HashMap<>();
            // Frequency -> number of distinct values with that frequency
            Map<Integer, Integer> freqCount = new HashMap<>();
            // largest occurrence count
            int maxFreq = 0;
            // Number of distinct values
            int distinct = 0;
            
            /**
             * Choose a starting index left. Reset both maps, ditinct and maxFreq
             * Extend right one position at a time. Each iteration considers the subarray nums[left..right]
             * Remove the added value from its old frequency group
             * Move that values into its frequency group
             * Check the current subarray is balanced or not
             */
            for (int right = left; right < nums.length; right++) {
                int x = nums[right];
                int oldFreq = freq.getOrDefault(x, 0);

                if (oldFreq == 0) {
                    distinct++;
                } else {
                    freqCount.put(oldFreq, freqCount.get(oldFreq) - 1);
                    if (freqCount.get(oldFreq) == 0) {
                        freqCount.remove(oldFreq);
                    }
                }

                int newFreq = oldFreq + 1;
                freq.put(x, newFreq);
                freqCount.put(newFreq, freqCount.getOrDefault(newFreq, 0) + 1);
                maxFreq = Math.max(maxFreq, newFreq);

                int len = right - left + 1;

                if (arrayIsBalanced(len, distinct, maxFreq, freqCount)) {
                    result = Math.max(result, len);
                }
            }
        }

        return result;
        
    }


    public boolean arrayIsBalanced(int arrayLen, int distinct, int maxFreq, Map<Integer, Integer> freqCount)  {
        if (arrayLen == 1) return true;
        if (distinct == 1) return true;
        if (maxFreq % 2 != 0) return false;
        int half = maxFreq / 2;
        int maxCount = freqCount.getOrDefault(maxFreq, 0);
        int halfCount = freqCount.getOrDefault(half, 0);
        return maxCount >= 1 && halfCount >= 1 && maxCount + halfCount == distinct;
    }
}
