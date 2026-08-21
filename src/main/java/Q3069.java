import java.util.ArrayList;
import java.util.List;

public class Q3069 {
    /**
     * You are given a 1-indexed array of distinct integers nums of length n.
     * You need to distribute all the elements of nums between two arrays arr1 and arr2 using n operations. 
     * In the first operation, append nums[1] to arr1. 
     * In the second operation, append nums[2] to arr2. Afterwards, in the ith operation:
     * If the last element of arr1 is greater than the last element of arr2, append nums[i] to arr1. Otherwise, append nums[i] to arr2
     * The array result is formed by concatenating the arrays arr1 and arr2. 
     * For example, if arr1 == [1,2,3] and arr2 == [4,5,6], then result = [1,2,3,4,5,6]
     * 
     * @param nums
     * @return
     */
    public int[] resultArray(int[] nums) {
        int[] result = new int[nums.length];
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        // Distributing elements of nums to arr1 and arr2
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0 && i != nums.length - 1) {
                nums1.add(nums[i]);
            } else if (i % 2 == 1 && i != nums.length - 1) {
                nums2.add(nums[i]);
            } else {
                // Last element distribution
                int lastNums1 = nums1.get(nums1.size() - 1);
                int lastNums2 = nums2.get(nums2.size() - 1);
                if (lastNums1 > lastNums2) {
                    nums1.add(nums[i]);
                } 
                else {
                    nums2.add(nums[i]);
                }
            }
        }
        int index = 0;
        // Concatenating the arrays arr1.
        for (int i = 0; i < nums1.size(); i++) {
            result[index] = nums1.get(i);
            index++;
        }
        // Concatenating the arrays arr2.
        for (int i = 0; i < nums2.size(); i++) {
            result[index] = nums2.get(i);
            index++;
        }

        return result;
    }
}
