package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q98_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q98 q98 = new Q98();
        boolean expectResult = true;
        boolean actualResult = q98.isValidBST(tree1());
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q98 q98 = new Q98();
        boolean expectResult = false;
        boolean actualResult = q98.isValidBST(tree2());
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(2);
        TreeNode leftNode = new TreeNode(1);
        TreeNode rightNode = new TreeNode(3);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    TreeNode tree2() {
        TreeNode root = new TreeNode(5);
        TreeNode leftNode = new TreeNode(1);
        TreeNode rightNode = new TreeNode(4);
        TreeNode rightLeftNode = new TreeNode(3);
        TreeNode rightRightNode = new TreeNode(6);
        root.left = leftNode;
        root.right = rightNode;
        rightNode.left = rightLeftNode;
        rightNode.right = rightRightNode;
        return root;
    }
}
