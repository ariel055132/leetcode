package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1120_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1120 q1120 = new Q1120();
        double expectResult = 6;
        double actualResult = q1120.maximumAverageSubtree(tree1());
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;
        return root;
    }
}
