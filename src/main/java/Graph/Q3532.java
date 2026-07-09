package Graph;

public class Q3532 {
    /**
     * You are given an integer n representing the number of nodes in a graph, labeled from 0 to n - 1.
     * You are also given an integer array nums of length n sorted in non-decreasing order, and an integer maxDiff
     * An undirected edge exists between nodes i and j if the absolute difference between nums[i] and nums[j] is at most maxDiff (i.e., |nums[i] - nums[j]| <= maxDiff).
     * You are also given a 2D integer array queries. For each queries[i] = [ui, vi], determine whether there exists a path between nodes ui and vi.
     * Return a boolean array answer, where answer[i] is true if there exists a path between ui and vi in the ith query and false otherwise.
     * 
     * @param n
     * @param nums
     * @param maxDiff
     * @param queries
     * @return
     */
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Build the components id array
        // Label each index in nums with which connected group it belongs to
        int[] components = new int[n];
        components[0] = 0;
        for (int i = 1; i < n; i++) {
            // Calculate the absolute difference between nums[i] and nums[i-1] (question: nums[i] and nums[j])
            int diff = Math.abs(nums[i] - nums[i-1]);
            // If absolute difference is less or equal to maxDiff, that means an undirected edge exists between node i and node i-1
            if (diff <= maxDiff) {
                components[i] = components[i-1];
            } else {
                // Otherwise, node i and node i-1 does not have an undirected edge
                components[i] = components[i-1]+1;
            }
        }

        // If u, and v have the same components value, that means they are connected to each other
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if (components[u] == components[v]) {
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        return result;
    }
}
