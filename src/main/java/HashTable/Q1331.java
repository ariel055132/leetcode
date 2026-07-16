package HashTable;

import java.util.Arrays;
import java.util.HashMap;

public class Q1331 {
    /**
     * Given an array of integers arr, replace each element with its rank.
     * The rank represents how large the element is. The rank has the following rules:
     * 1. Rank is an integer starting from 1.
     * 2. The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
     * 3. Rank should be as small as possible.
     * 
     * Sort the array
     * Use Hashmap to store the value with rank
     * 
     * @param arr
     * @return
     */
    public int[] arrayRankTransform(int[] arr) {
        int[] result = new int[arr.length];
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        for (int ele : sortedArr) {
            if (!map.containsKey(ele)) {
                map.put(ele, idx);
                idx++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int ele = arr[i];
            int val = map.get(ele);
            result[i] = val;
        }
        return result;
    }
}
