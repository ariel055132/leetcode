import java.util.ArrayList;

public class Q2553 {
    /**
     * Given an array of positive integers nums, return an array answer that consists of the digits of each integer in nums after separating them in the same order they appear in nums.
     * To separate the digits of an integer is to get all the digits it has in the same order.
     * For example, for the integer 10921, the separation of its digits is [1,0,9,2,1].
     * 
     * Solution
     * 1. Traverse the array nums
     * 2. For each integer in nums, separate the digits and add them to a temporary list
     * 3. Reverse the temporary list and add the digits to the result list
     * 4. Convert the result list to an array and return it
     * 
     * @param nums
     * @return
     */
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        // 1. Traverse the array nums
        for (int num : nums) {
            ArrayList<Integer> tmpList = new ArrayList<>();
            // 2. For each integer in nums, separate the digits and add them to a temporary list
            while (num > 0) {
                int digit = num % 10;
                tmpList.add(digit);
                num = num / 10;
            }
            // 3. Reverse the temporary list and add the digits to the result list
            for (int i = tmpList.size() - 1; i >= 0; i--) {
                list.add(tmpList.get(i));
            }
        }
        // 4. Convert the result list to an array and return it
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
