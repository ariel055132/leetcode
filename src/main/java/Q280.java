import java.util.Arrays;

public class Q280 {
    /**
     * Swap the elements inside array nums
     * 
     * @param nums int[]
     * @param i int
     * @param j int
     */
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 
     * Reorder the given array in such as way that every element at an odd index is greater than or equal to its two adjacent elements at even indices
     * Sort the array.
     * Then for every element at an odd index (i) do a swap with its adjacent element at index i+1
     * 
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        } 
    }
}
