public class Q3876 {
    /**
     * You are given an array nums1 of n distinct integers.
     * You want to construct another array nums2 of length n such that the elements in nums2 are either all odd or all even.
     * For each index i, you must choose exactly one of the following (in any order):
     * 1. nums2[i] = nums1[i]
     * 2. nums2[i] = nums1[i] - nums1[j], for an index j != i, such that nums1[i] - nums1[j] >= 1
     * Return true if it is possible to construct such an array, otherwise return false.
     * 
     * Three situations about the nums1
     * Elements in nums1 are all odd or all even -> return true
     * Due to nums1[i] - nums1[j] >= 1, nums1[j] should be a minimum.
     * if nums1[j] is odd number, the constructed array should be all odd.
     * -> even - odd = odd (*) ; odd - odd = even
     * if nums1[j] is even number, the constructed array should be all even
     * -> odd - even = odd ; even - even = even (*)
     * Therefore, the valid construction is possible when:
     * The minimum element is odd 
     * All elements are evne
     * 
     * @param nums1
     * @return
     */
    public boolean uniformArray(int[] nums1) {
        int minimum = Integer.MAX_VALUE;
        int oddCount = 0;
        for (int num : nums1) {
            minimum = Math.min(num, minimum);
            if (num % 2 == 1) oddCount++;
        }
        if (minimum % 2 == 1) {
            return true;
        } else {
            if (oddCount != 0) return false;
            return true;
        }
    }
}
