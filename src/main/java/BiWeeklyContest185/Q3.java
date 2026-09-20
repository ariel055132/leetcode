package BiWeeklyContest185;

import java.util.ArrayList;
import java.util.List;

public class Q3 {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        List<List<Integer>> adjacentGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacentGraph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacentGraph.get(u).add(v);
        }

        return dfs(0, adjacentGraph, baseTime);
    }


    public long dfs(int node, List<List<Integer>> adjacentGraph, int[] baseTime) {
            List<Integer> children = adjacentGraph.get(node);
            if (children.isEmpty()) {
                return baseTime[node];
            }
            long earliest = Long.MAX_VALUE;
            long latest = Long.MIN_VALUE;
            
            for (int child : children) {
                long childFinishTime = dfs(child, adjacentGraph, baseTime);
                earliest = Math.min(earliest, childFinishTime);
                latest = Math.max(latest, childFinishTime);
            }

            long ownDuration = (latest - earliest) + baseTime[node];
            long result = latest + ownDuration;
            return result;

    }

}
