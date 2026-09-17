package BitManipulation;

import java.util.HashSet;
import java.util.Set;

public class Q3514_BruteForce {
    /**
     * You are given an integer array nums.
     * A XOR triplet is defined as the XOR of three elements nums[i] XOR nums[j] XOR nums[k] where i <= j <= k.
     * Return the number of unique XOR triplet values from all possible triplets (i, j, k).
     * 
     * Just enumerate as the question stated by calcuting all the possible elements in nums.
     * 
     * @param nums
     * @return
     */
    public int uniqueXorTriplets(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {
                    int xorValue = nums[i] ^ nums[j] ^ nums[k];
                    if (!set.contains(xorValue)) {
                        set.add(xorValue);
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
