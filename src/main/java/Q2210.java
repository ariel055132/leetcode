import java.util.ArrayList;

public class Q2210 {
    public int countHillValleys(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        while (index < nums.length) {
            // Skip duplicates of nums array
            while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
                index++;
            }
            // Add the current unique element to the list
            list.add(nums[index]);
            index++;
        }
        int result = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            // Check if the element is hiil or valley
            if ((list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1)) ||
                    (list.get(i) < list.get(i - 1) && list.get(i) < list.get(i + 1))) {
                result++;
            }
        }
        return result;
    }
}
