package HashTable;

import java.util.HashSet;
import java.util.Set;

public class Q3718 {
    /**
     * Given an integer array nums and an integer k, return the smallest positive multiple of k that is missing from nums.
     * A multiple of k is any positive integer divisible by k.
     * 
     * Use a hashset to save the elements in array nums
     * For each candidate:
     * If it exists, advance to the next multiple.
     * If it does not exist, return it immediately.
     * Checking candidates in increasing order guarantees that the returned value is the smallest missing multiple.
     * @param nums
     * @param k
     * @return
     */
    public int missingMultiple(int[] nums, int k) {
        int result = k;
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        while (true) {
            if (numsSet.contains(result)) {
                result += k;
            } else {
                return result;
            }
        }
    }
}
