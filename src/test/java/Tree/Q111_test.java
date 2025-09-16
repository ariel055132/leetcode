package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q111_test {
    @Test
    @DisplayName("Example 1")
    void test1() {
        Q111 q111 = new Q111();
        TreeNode root = example1();
        int expectResult = 2;
        int actualResult = q111.minDepth(root);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Example 2")
    void test2() {
        Q111 q111 = new Q111();
        TreeNode root = example2();
        int expectResult = 5;
        int actualResult = q111.minDepth(root);
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode example1() {
        TreeNode root = new TreeNode(3);
        TreeNode leftTreeNode = new TreeNode(9);
        TreeNode rightTreeNode = new TreeNode(20);
        TreeNode rightLeftTreeNode = new TreeNode(15);
        TreeNode rightRightTreeNode = new TreeNode(7);
        root.left = leftTreeNode;
        root.right = rightTreeNode;
        rightTreeNode.left= rightLeftTreeNode;
        rightTreeNode.right = rightRightTreeNode;
        return root;
    }

    TreeNode example2() {
        TreeNode root = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        return root;
    }
}
