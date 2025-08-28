package BinarySearch;

import java.util.Arrays;

public class Q2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int currentSpell = spells[i];
            int left = 0;
            int right = potions.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long tmp = (long) currentSpell * potions[mid];
                if (tmp >= success) {
                    right = mid - 1;
                } else {
                    // left indicates the index where product of currentSpell * potions[left] must less than success
                    left = mid + 1;
                }
            }
            result[i] = potions.length - left; // Ensure the result must greater and equal than success
        }
        return result;
    }

}
