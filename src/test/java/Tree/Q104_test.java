package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q104_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q104 q104 = new Q104();
        int expectResult = 3;
        int actualResult = q104.maxDepth(tree1());
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(3);
        TreeNode leftRoot = new TreeNode(9);
        TreeNode rightRoot = new TreeNode(20);
        TreeNode rightLeftNode = new TreeNode(15);
        TreeNode rightRightNode = new TreeNode(7);
        root.left = leftRoot;
        root.right = rightRoot;
        rightRoot.left = rightLeftNode;
        rightRoot.right = rightRightNode;
        return root;
    }

    TreeNode tree2() {
        TreeNode root = new TreeNode();
        return root;
    }
}
