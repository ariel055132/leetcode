package Blind75;

import java.util.HashSet;
import java.util.Set;

public class Q217 {
    public boolean containsDuplicate(int[] nums) {
        // Use a Set to check if the insertion of a string is successful to determine if it's a duplicate element.
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
