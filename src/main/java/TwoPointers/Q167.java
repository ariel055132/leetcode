package TwoPointers;

public class Q167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            if (currentSum == target) {
                result[0] = left + 1; // 1-indexed, therefore plus one
                result[1] = right + 1; // same as above
                // Question stated that the tests are generated such that there is exactly one solution.
                break;
            } else if (currentSum > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
