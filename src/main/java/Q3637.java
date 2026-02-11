public class Q3637 {
    /**
     * A trionic array is an array that has a peak element, and all elements before the peak are strictly increasing,
     * and all elements after the peak are strictly decreasing.
     * <p>
     * Example: [1, 2, 3, 2, 1] is a trionic array.
     * Example: [1, 2, 3, 4] is not a trionic array.
     * Example: [4, 3, 2, 1] is not a trionic array.
     *
     * 1. A strictly increasing segment.
     * 2. A strictly decreasing segment.
     * 3. Another strictly increasing segment.
     *
     * @param nums the input array
     * @return true if the array is trionic, false otherwise
     */
    public boolean isTrionic(int[] nums) {
        int index = 0;
        int indexP = 0;
        int indexQ = 0;
        if (nums == null || nums.length < 3) {
            return false; // A trionic array must have at least 3 elements
        }
        // Strictly increasing
        while (index + 1 < nums.length && nums[index] < nums[index + 1]) {
            index++;
        }
        /**
         * Must have at least one element before and after the peak
         */
        if (index == 0 || index == nums.length - 1) {
            return false;
        }
        indexP = index;
        // Strictly decreasing
        while (index + 1 < nums.length && nums[index] > nums[index + 1]) {
            index++;
        }
        if (index == indexP || index == nums.length - 1) {
            return false;
        }
        while (index + 1 < nums.length && nums[index] < nums[index + 1]) {
            index++;
        }
        return index == nums.length - 1;
    }

    public boolean isTrionic1(int[] nums) {
        int p = 0;
        int q = 0;
        int f = 0; // f == n - 1, where n is the length of nums
        int i = 1; // index
        // nums[0...p] is strictly increasing
        while (i < nums.length && nums[i - 1] < nums[i]) {
            i++;
        }
        p = i - 1;
        // nums[p...q] is strictly decreasing
        while (i < nums.length && nums[i - 1] > nums[i]) {
            i++;
        }
        q = i - 1;
        while (i < nums.length && nums[i - 1] < nums[i]) {
            i++;
        }
        f = i - 1;
        if (p == q || p == 0 || f == q) {
            return false;
        }
        return true;
    }
}
