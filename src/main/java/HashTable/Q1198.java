package HashTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Q1198 {
    /**
     * Given an m x n matrix mat where every row is sorted in strictly increasing order, return the smallest common element in all rows.
     * If there is no common element, return -1.
     * 
     * Solution:
     * 1. Use a HashMap to count the frequencies of elements in the matrix.
     * 2. Iterate through the HashMap and find the element with values equal to the number of rows in the matrix.
     * 3. If the element with the highest frequency is found, return it.
     * 4. If no element with the highest frequency is found, return -1.
     * 
     * @param matrix
     * @return
     */
    public int smallestCommonElement(int[][] matrix) {
        // Count the frequencies of elements in the matrix
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] mat : matrix) {
            for (int ele : mat) {
                map.put(ele, map.getOrDefault(ele, 0)+1);
            }
        }
        // Find the elements with the highest frequency
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == matrix.length) list.add(key);
        }
        // Sort the list of elements and return the smallest element
        Collections.sort(list);
        // If the list is empty, return -1
        if (list.isEmpty()) return -1;
        // Return the smallest element
        return list.get(0);
    }
}
