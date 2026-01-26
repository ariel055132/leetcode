import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            int currentDiff = Math.abs(arr[i] - arr[i-1]);
            if (currentDiff == minDiff) {
                List<Integer> tmpResult = new ArrayList<>();
                tmpResult.add(arr[i-1]);
                tmpResult.add(arr[i]);
                result.add(tmpResult);
            } else if (currentDiff < minDiff) {
                minDiff = currentDiff;
                result.clear();
                List<Integer> tmpResult = new ArrayList<>();
                tmpResult.add(arr[i-1]);
                tmpResult.add(arr[i]);
                result.add(tmpResult);
            }
        }
        return result;
    }
}
