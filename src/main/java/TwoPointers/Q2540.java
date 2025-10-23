package TwoPointers;

public class Q2540 {
    /**
     * Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays.
     * If there is no common integer amongst nums1 and nums2, return -1.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int getCommon(int[] nums1, int[] nums2) {
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int nums1Index = 0;
        int nums2Index = 0;
        int result = Integer.MAX_VALUE;
        while (nums1Index < nums1Len && nums2Index < nums2Len) {
            if (nums1[nums1Index] == nums2[nums2Index]) {
                result = nums1[nums1Index];
                break;
            } else if (nums1[nums1Index] > nums2[nums2Index]) {
                nums2Index++;
            } else {
                nums1Index++;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
