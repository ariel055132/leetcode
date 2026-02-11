package TwoPointers;

public class Q88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int num1Index = m - 1;
        int num2Index = n - 1;
        int bothIndex = m + n - 1;
        while (num1Index >= 0 && num2Index >= 0) {
            if (nums1[num1Index] >= nums2[num2Index]) {
                nums1[bothIndex] = nums1[num1Index];
                bothIndex--;
                num1Index--;
            } else {
                nums1[bothIndex] = nums2[num2Index];
                bothIndex--;
                num2Index--;
            }
        }

        while (num2Index > 0) {
            nums1[bothIndex] = nums2[num2Index];
            bothIndex--;
            num2Index--;
        }

    }
}
