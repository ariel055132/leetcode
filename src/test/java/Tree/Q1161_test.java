package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1161_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1161 q1161 = new Q1161();
        int expectResult = 2;
        int actualResult = q1161.maxLevelSum(tree1());
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1161 q1161 = new Q1161();
        int expectResult = 2;
        int acutalResult = q1161.maxLevelSum(tree2());
        Assertions.assertEquals(expectResult, acutalResult);
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(7);
        TreeNode rightNode = new TreeNode(0);
        TreeNode leftLeftNode = new TreeNode(7);
        TreeNode leftRightNode = new TreeNode(-8);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = leftLeftNode;
        leftNode.right = leftRightNode;
        return root;
    }

    TreeNode tree2() {
        TreeNode root = new TreeNode(989);
        TreeNode rightNode = new TreeNode(10250);
        TreeNode rightLeftNode = new TreeNode(98693);
        TreeNode rightRightNode = new TreeNode(-89388);
        TreeNode rightRightRightNode = new TreeNode(-32127);
        root.right = rightNode;
        rightNode.left = rightLeftNode;
        rightNode.right = rightRightNode;
        rightRightNode.right = rightRightRightNode;
        return root;
    }
}
