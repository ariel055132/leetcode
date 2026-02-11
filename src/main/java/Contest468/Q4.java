package Contest468;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Q4 {

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> numsQueues = new PriorityQueue<>();

        System.out.println("Generating subarrays:");

        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int max = nums[i];

            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                int value = max - min;
                if (numsQueues.size() < k) {
                    numsQueues.offer(value);
                } else if (value > numsQueues.peek()) {
                    numsQueues.poll();
                    numsQueues.offer(value);
                }
            }
        }

        long totalValue = 0;
        while (!numsQueues.isEmpty()) {
            totalValue += numsQueues.poll();
        }

        System.out.println("Sum of top " + k + " values: " + totalValue);
        return totalValue;
    }
        public long maximumSubarraySum(int[] nums, int k) {
            int n = nums.length;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

            // For each possible max-min difference, find if such subarray exists
            Set<Integer> uniqueValues = new TreeSet<>();
            for (int num : nums) {
                uniqueValues.add(num);
            }

            List<Integer> sortedUnique = new ArrayList<>(uniqueValues);

            // Generate possible subarray values efficiently
            for (int i = 0; i < sortedUnique.size(); i++) {
                for (int j = i; j < sortedUnique.size(); j++) {
                    int minVal = sortedUnique.get(i);
                    int maxVal = sortedUnique.get(j);
                    int value = maxVal - minVal;

                    // Check if there exists a subarray with this min and max
                    if (hasSubarrayWithMinMax(nums, minVal, maxVal)) {
                        maxHeap.offer(value);
                    }
                }
            }

            // Sum top k values
            long result = 0;
            for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
                result += maxHeap.poll();
            }

            return result;
        }

        private boolean hasSubarrayWithMinMax(int[] nums, int minVal, int maxVal) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] < minVal || nums[i] > maxVal) continue;

                int currentMin = nums[i];
                int currentMax = nums[i];
                boolean hasMin = (nums[i] == minVal);
                boolean hasMax = (nums[i] == maxVal);

                for (int j = i; j < n; j++) {
                    if (nums[j] < minVal || nums[j] > maxVal) break;

                    currentMin = Math.min(currentMin, nums[j]);
                    currentMax = Math.max(currentMax, nums[j]);
                    hasMin |= (nums[j] == minVal);
                    hasMax |= (nums[j] == maxVal);

                    if (hasMin && hasMax && currentMin == minVal && currentMax == maxVal) {
                        return true;
                    }
                }
            }
            return false;

    }

}
