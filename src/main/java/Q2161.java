public class Q2161 {
    /**
     * You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:
     * 1. Every element less than pivot appears before every element greater than pivot.
     * 2. Every element equal to pivot appears in between the elements less than and greater than pivot.
     * 3. The relative order of the elements less than pivot and the elements greater than pivot is maintained. 
     * 
     * This is a stable partition into three groups.
     * Since relative order matters, do not swap elements like normal quicksort paritioning.
     * Instead, scan left to right and append elements in order.
     * 
     * 1. Create an answer array with ans.
     * 2. First pass: copy all values < pivot
     * 3. Second pass: copy all values == pivot
     * 4. Third pass: copy all values > pivot
     * 5. Return ans
     * 
     * @param nums
     * @param pivot
     * @return
     */
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            if (num < pivot) {
                result[i] = num;
                i++;
            }
        }
        for (int num : nums) {
            if (num == pivot) {
                result[i] = num;
                i++;
            }
        }
        for (int num : nums) {
            if (num > pivot) {
                result[i] = num;
                i++;
            }
        }
        return result;
    }
}
