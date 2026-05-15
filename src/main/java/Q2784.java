import java.util.Arrays;

public class Q2784 {
    /**
     * You are given an integer array nums. We consider an array good if it is a permutation of an array base[n].
     * base[n] = [1, 2, ..., n - 1, n, n] (in other words, it is an array of length n + 1 which contains 1 to n - 1 exactly once, plus two occurrences of n). 
     * For example, base[1] = [1, 1] and base[3] = [1, 2, 3, 3].
     * Return true if the given array is good, otherwise return false.
     * 
     * Just simulate with the question statement
     * 
     * @param nums int[]
     * @return
     */
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        // maxNum == n (in the question)
        int maxNum = nums[nums.length - 1];
        // As base[n] = [1, 2, ..., n-1, n, n], shows that good array should have 2 n, which equal to the length of array
        // Therefore, return false if the above condition is not satisfied
        if (maxNum + 1 != nums.length) return false;
        // Traverse the array to find the middle part of elements fulfill the condition
        // If not fulfill, just return false
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }
        // Check out the last element 
        return nums[nums.length - 1] == nums.length - 1;
    }
}
