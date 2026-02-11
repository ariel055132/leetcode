package TwoPointers;

import java.util.Arrays;

public class Q1577 {
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        return helper(nums1, nums2) + helper(nums2, nums1);
    }

    public int helper(int[] nums1, int[] nums2) {
        int result = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = 0; i < len1; i++) {
            int num1SqValue = nums1[i] * nums1[i];
            int left = 0;
            int right = len2 - 1;
            while (left < right) {
                int num2Value = nums2[left] * nums2[right];
                if (num1SqValue == num2Value) {
                    if (nums2[left] == nums2[right]) {
                        result += (right - left + 1) * (right - left) / 2;
                        break;
                    } else {
                        int leftCount = 1;
                        int rightCount = 1;
                        while (left < right && nums2[left] == nums2[left + 1]) {
                            leftCount++;
                            left++;
                        }
                        while (left < right && nums2[right] == nums2[right - 1]) {
                            rightCount--;
                            right--;
                        }
                        result += rightCount * leftCount;
                        left++;
                        right--;
                    }
                } else if (num1SqValue > num2Value) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
