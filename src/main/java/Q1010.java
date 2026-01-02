import java.util.HashMap;
import java.util.Map;

public class Q1010 {
    /**
     * You are given a list of songs where the ith song has a duration of time[i] seconds.
     * Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
     * Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
     *
     * @param time int[]
     * @return int
     */
    public int numPairsDivisibleBy60(int[] time) {
        int result = 0;
        // Map -> Key: time, Value: frequencies of time
        Map<Integer, Integer> map = new HashMap<>();
        for(int ti : time) {
            int timeRemainder = ti % 60;
            // Calculate diff in order to find the pair
            int diff = 60 - timeRemainder;
            // If the map has the key (pair), increment the result with the frequencies of time
            // Do this first in order to prevent duplicate calculation
            if (map.containsKey(diff)) {
                result += map.get(diff);
            }
            // Update the map with the timeRemainder
            if (timeRemainder != 0) {
                map.put(timeRemainder, map.getOrDefault(timeRemainder, 0) + 1);
            } else {
                // 60 need to do it separately as timeRemainder is 0.
                map.put(60, map.getOrDefault(60, 0) + 1);
            }
        }

        return result;
    }
}
