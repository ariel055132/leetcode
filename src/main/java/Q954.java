import java.util.Arrays;
import java.util.TreeMap;

public class Q954 {
    public boolean canReorderDoubled(int[] arr) {
        // Sort the array in ascending order
        Arrays.sort(arr);
        // Save the occurrence of element with map, use treeMap to keep the key is sorted
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        // Traverse the key set in map
        for(int even : map.keySet()) {
            // If value of key is not zero, that means we need to find another element which is twice values as key to do the pairing
            if(map.get(even) != 0){
                // Find the twice values of even
                int odd = even < 0 ? even / 2 : even * 2;
                // Find out whether odd is exist in map, if not / it is already zero, return false
                if(map.containsKey(odd) && map.get(odd) >= map.get(even)){
                    map.put(odd, map.get(odd) - map.get(even));
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}
