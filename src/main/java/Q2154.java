import java.util.HashSet;

public class Q2154 {
    /**
     * Store nums array elements in a set
     * Loop through each number in the set
     * When original matches a set element, double original
     * Return the updated original value after completing the job
     *
     * @param nums int[]
     * @param original int
     * @return int (the final value of original)
     */
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (set.contains(original)) {
                original *= 2;
            }
        }
        return original;
    }
}
