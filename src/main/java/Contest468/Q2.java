package Contest468;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2 {
    public long maxTotalValue(int[] nums, int k) {
        List<Integer> subArrayValues = new ArrayList<>();

        // Calculates the all possible values of subarray
        for (int i = 0; i < nums.length; i++) {
            int currentMin = nums[i];
            int currentMax = nums[i];
            for (int j = i; j < nums.length; j++) {
                currentMin = Math.min(currentMin, nums[j]);
                currentMax = Math.max(currentMax, nums[j]);

                int value = currentMax - currentMin;
                subArrayValues.add(value);
            }
        }
        // Sort the subarray with values in descending order
        Collections.sort(subArrayValues, Collections.reverseOrder());
        long totalValue = 0;
        long highestValue = subArrayValues.get(0);
        for (int i = 0; i < k; i++) {
            totalValue += highestValue;
        }
        return  totalValue;
    }

    public long maxTotalValue1(int[] nums, int k) {
        long maxValue = 0;

        // Find the maximum subarray value without storing all values
        for (int i = 0; i < nums.length; i++) {
            long currentMin = nums[i];
            long currentMax = nums[i];

            for (int j = i; j < nums.length; j++) {
                // Update min and max for current subarray [i, j]
                currentMin = Math.min(currentMin, nums[j]);
                currentMax = Math.max(currentMax, nums[j]);

                // Calculate value of subarray [i, j]
                long value = currentMax - currentMin;
                maxValue = Math.max(maxValue, value);
            }
        }

        // Choose the best subarray k times
        return (long) maxValue * k;
    }
}
