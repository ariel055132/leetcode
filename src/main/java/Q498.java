import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;

public class Q498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null) return new int[0];
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int[] result = new int[matrix.length * matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                List<Integer> list;
                if (!map.containsKey(i + j)) {
                    list = new ArrayList<>();
                } else {
                    list = map.get(i + j);
                }
                list.add(matrix[i][j]);
                map.put(i + j, list);
            }
        }

        int index = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> tmpList = entry.getValue();
            // Ziz zag traversal, where even diagonal should be reversed
            if (entry.getKey() % 2 == 0) {
                Collections.reverse(tmpList);
            }
            for (int i = 0; i < tmpList.size(); i++) {
                result[index] = tmpList.get(i);
                index++;
            }
        }
        return result;
    }
}
