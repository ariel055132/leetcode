package Graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q2192_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2192 q2192 = new Q2192();
        int n = 8;
        int[][] edgeList = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
        System.out.println(q2192.getAncestors(n, edgeList));
    }
}
