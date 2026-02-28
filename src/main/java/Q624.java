import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q624 {
    /**
     * Greedy single-pass approach that maintains global minimum and maximum values while iterating through arrays
     * The maximum distance between two sorted arrays will always be between:
     * The maximum element of one array and the minimum elements of another array
     *
     * @param arrays
     * @return
     */

    public int maxDistance(List<List<Integer>> arrays) {
        int result = 0;
        // init minVal and maxVal
        // maxVal can be defined as following as question is stated, each array is sorted in ascending order
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size()-1);
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);
            int distance1 = Math.abs(currentMax - minVal);
            int distance2 = Math.abs(maxVal - currentMin);

            result = Math.max(result, Math.max(distance1, distance2));
            minVal = Math.min(minVal, arrays.get(i).get(0));
            maxVal = Math.max(maxVal, arrays.get(i).get(arrays.get(i).size()-1));
        }

        return result;
    }
}
