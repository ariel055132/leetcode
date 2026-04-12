import java.util.HashSet;
import java.util.Set;

public class Q1980 {
    public String findDifferentBinaryString(String[] nums) {
        // Save the binary string num to set
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(Integer.parseInt(nums[i], 2));
        }
        int n = nums.length;
        for (int num = 0; num <= n; num++) {
            if (!set.contains(num)) {
                String ans = Integer.toBinaryString(num);
                // Complement 0
                while (ans.length() < n) {
                    ans = '0' + ans;
                }
                return ans;
            }
        }
        return "";
    }
}
