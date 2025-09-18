package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q101_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q101 q101 = new Q101();
        boolean expectResult = true;
        boolean actualResult = q101.isSymmetric(tree1());
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q101 q101 = new Q101();
        boolean expectResult = false;
        boolean actualResult = q101.isSymmetric(tree2());
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(2);
        TreeNode leftLeftNode = new TreeNode(3);
        TreeNode leftRightNode = new TreeNode(4);
        TreeNode rightLeftNode = new TreeNode(4);
        TreeNode rightRightNode = new TreeNode(3);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = leftLeftNode;
        leftNode.right = leftRightNode;
        rightNode.left = rightLeftNode;
        rightNode.right = rightRightNode;
        return root;
    }

    TreeNode tree2() {
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(2);
        TreeNode leftRightNode = new TreeNode(3);
        TreeNode rightRightNode = new TreeNode(3);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.right = leftRightNode;
        rightNode.right = rightRightNode;
        return root;
    }
}
