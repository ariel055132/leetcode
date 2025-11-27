import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1128 {
    /**
     * Just Count the number of different dominoes
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int result = 0;
        // Key: Pair<dominoes[][], dominoes[][]>>
        // Value: Integer (freq of Pair)
        Map<Map.Entry<Integer, Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            // Do the rotation of domino by Array.sort
            Arrays.sort(dominoes[i]);
            if (map.get(new AbstractMap.SimpleEntry<>(dominoes[i][0], dominoes[i][1])) == null) {
                // No Pair of dominoes is found -> initialize it as 1
                map.put(new AbstractMap.SimpleEntry<>(dominoes[i][0], dominoes[i][1]), 1);
            } else {
                // Found the Pair of dominoes -> get the value and increment it by 1
                map.put(new AbstractMap.SimpleEntry<>(dominoes[i][0], dominoes[i][1]), map.get(new AbstractMap.SimpleEntry<>(dominoes[i][0], dominoes[i][1])) + 1);
            }
            // Update current result
            result += map.get(new AbstractMap.SimpleEntry<>(dominoes[i][0], dominoes[i][1])) - 1;
        }

        return result;
    }
}
