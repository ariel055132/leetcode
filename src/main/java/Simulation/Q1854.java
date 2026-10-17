package Simulation;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Q1854 {
    public int maximumPopulation(int[][] logs) {
        int[][] processedLogs = logs;
        TreeMap<Integer, Integer> map = new TreeMap();
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < processedLogs.length; i++) {
            int end = processedLogs[i][1];
            processedLogs[i][1] = end - 1;
        }
        for (int i = 0; i < processedLogs.length; i++) {
            int start = processedLogs[i][0];
            int end = processedLogs[i][1];
            if (!map.containsKey(start)) {
                map.put(start, 1);
            } else {
                map.put(start, map.get(start) + 1);
            }

            if (!map.containsKey(end)) {
                map.put(end, 1);
            } else {
                map.put(end, map.get(end) + 1);
            }
        }

        int maxCount = 0;
        int earliestYear = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                earliestYear = entry.getKey();
            }
        }

        return earliestYear;
    }

}
