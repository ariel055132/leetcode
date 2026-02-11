package TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class Q658 {
    public List<Integer> findClosestElement(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
