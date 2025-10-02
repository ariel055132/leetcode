package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q530_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q530 q530 = new Q530();
        int expectResult = 1;
        int actualResult = q530.getMinimumDifference(tree1());
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(4);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(6);
        TreeNode leftLeftNode = new TreeNode(1);
        TreeNode leftRightNode = new TreeNode(3);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = leftLeftNode;
        leftNode.right = leftRightNode;
        return root;
    }
}
