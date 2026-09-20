package BiWeeklyContest185;

public class Q2 {
    /**
     * You are given an integer array lights of length n, representing positions 0 through n - 1 on a road
     * For each position i:
     * If lights[i] = v, where v > 0, there is a working bulb at position i that illuminates every position from max(0, i - v) to min(n - 1, i + v), inclusive.
     * If lights[i] = 0, there is no working bulb at position i.
     * A position is visible if it is illuminated by at least one working bulb.
     * You may install additional bulbs at any positions. Each additional bulb installed at position j illuminates positions from max(0, j - 1) to min(n - 1, j + 1), inclusive.
     * Return the minimum number of additional bulbs required to make every position on the road visible.
     * 
     * The key idea is to first determine which positions are already illuminated, then count consecutive dark positions.
     * 
     * 
     * @param lights
     * @return
     */
    public int minAdditionalBulbs(int[] lights) {
        int n = lights.length;
        int[] diff = new int[n + 1];

        // Record each existing bulb's coverage interval.
        for (int i = 0; i < n; i++) {
            int v = lights[i];
            if (v > 0) {
                int left = Math.max(0, i - v);
                int right = Math.min(n - 1, i + v);
                diff[left]++;
                diff[right + 1]--;
            }
        }

        int ans = 0;
        int active = 0;
        int invisibleLen = 0;

        for (int i = 0; i < n; i++) {
            active += diff[i];

            if (active > 0) {
                ans += (invisibleLen + 2) / 3;
                invisibleLen = 0;
            } else {
                invisibleLen++;
            }
        }
        
        // Account for a dark segment ending at the last position.
        ans += (invisibleLen + 2) / 3;
        return ans;
    }
}

    
