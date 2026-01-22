package Quests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q6 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, true);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
