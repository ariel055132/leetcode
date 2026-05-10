package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q270_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q270 q270 = new Q270();
        TreeNode root = tree1();
        double target = 3.714286;
        int expectResult = 4;
        int actualResult = q270.closestValue(root, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q270 q270 = new Q270();
        TreeNode root = tree2();
        double target = 4.428571;
        int expectResult = 1;
        int actualResult = q270.closestValue(root, target);
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(4);
        TreeNode leftTreeNode = new TreeNode(2);
        TreeNode rightTreeNode = new TreeNode(5);
        TreeNode leftLeftTreeNode = new TreeNode(1);
        TreeNode leftRightTreeNode = new TreeNode(3);
        root.left = leftTreeNode;
        root.right = rightTreeNode;
        leftTreeNode.left = leftLeftTreeNode;
        leftTreeNode.right = leftRightTreeNode;
        return root;
    }

    TreeNode tree2() {
        TreeNode root = new TreeNode(1);
        return root;
    }
}
