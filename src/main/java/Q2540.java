import java.util.HashSet;
import java.util.Set;

public class Q2540 {
    /**
     * Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.
     * 
     * Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.
     * 
     * As both nums1, and nums2 are sorted in non-decreasing order.
     * Just use a set to save the elements in nums1
     * Traverse the nums2
     * If element is inside set, it must be the minimum common value, just return.
     * @param nums1
     * @param nums2
     * @return
     */
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                return num;
            }
        }
        return -1;
    }
}
