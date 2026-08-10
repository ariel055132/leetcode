import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3731 {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        // Sort array nums
        Arrays.sort(nums);
        // Define variable currElement as the next expected number
        int currElement = nums[0];
        // Traverse the array
        for (int i = 0; i < nums.length; currElement++, i++) {
            // When currElement < nums[i], adding it to the result
            if (currElement < nums[i]) {
                result.add(currElement);
                // Using i to examine the same array element after currElement increases
                i--;
            }
        }
        return result;
    }
}
