import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Q1356 {
    /**
     * You are given an integer array arr. 
     * Sort the integers in the array in ascending order by the number of 1's in their binary representation
     * In case of two or more integers have the same number of 1's you have to sort them in ascending order.
     * 
     * @param arr
     * @return
     */
    public int[] sortByBits(int[] arr) {
        int[] result = new int[arr.length];
        
        // Group numbers by their bit count using TreeMap for automatic key sorting
        // Key: count of 1-bits in binary form, Value: sorted list of numbers with that bit count
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            int bits = Integer.bitCount(arr[i]);
            List<Integer> list = map.computeIfAbsent(bits, k -> new ArrayList<>());
            list.add(arr[i]);
            list.sort(null);
        }
        
        // Flatten the sorted groups into the result array
        int index = 0;
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (Integer num : list) {
                result[index++] = num;
            }
        }
        
        return result;   
    }
}
