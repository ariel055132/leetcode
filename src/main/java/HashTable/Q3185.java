package HashTable;

import java.util.HashMap;

public class Q3185 {
    /**
     * Given an integer array hours representing times in hours, return an integer denoting the number of pairs i, j where i < j and hours[i] + hours[j] forms a complete day
     * A complete day is defined as a time duration that is an exact multiple of 24 hours.
     * For example, 1 day is 24 hours, 2 days is 48 hours, 3 days is 72 hours, and so on.
     *
     * For each current value, count how many previous values have the complementary remainder
     * For example,
     * 30 % 24 = 6, 18 % 24 = 18, therefore 6 + 18 = 24 -> valid pair
     *
     * @param hours
     * @return
     */
    public long countCompleteDayPairs(int[] hours) {
        long result = 0;
        // map Stores remainder -> how many times seen so far
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int hour : hours) {
            int hourRemainder = hour % 24;
            // Lookup diff = 24 - hourRemainder. Add its frequency to result
            int diff = 24 - hourRemainder;

            if (map.containsKey(diff)) {
                result += map.get(diff);
            }
            if (hourRemainder != 0) {
                map.put(hourRemainder, map.getOrDefault(hourRemainder, 0) + 1);
            } else {
                map.put(24, map.getOrDefault(24, 0) + 1);
            }
        }
        return result;
    }
}
