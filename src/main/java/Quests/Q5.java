package Quests;

import java.util.Arrays;
import java.util.TreeMap;

public class Q5 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] numsCopy = nums.clone();
        Arrays.sort(numsCopy);

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(numsCopy[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            numsCopy[i] = map.get(nums[i]);
        }

        return numsCopy;
    }
}
