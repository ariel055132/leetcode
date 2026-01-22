package Quests;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q4 {
    public int[] findErrorNums(int[] nums) {
        int duplicates = 0; // Number that occurs twice in nums
        int missing = 0; // Number that missing in nums
        int[] result = new int[2];
        Map<Integer, Integer> map = IntStream.rangeClosed(1, nums.length)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> 0));
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > 1) {
                duplicates = num;
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 0) {
                missing = entry.getKey();
                break;
            }
        }
        result[0] = duplicates;
        result[1] = missing;
        return result;
    }
}
