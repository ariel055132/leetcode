package Blind75;

import Tree.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q572_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q572 q572 = new Q572();
        boolean expectResult = true;
        boolean actualResult = q572.isSubtree(q1Tree(), q1SubTree());
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q572 q572 = new Q572();
        boolean expectResult = false;
        boolean actualResult = q572.isSubtree(q2Tree(), q2SubTree());
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Hidden Case")
    void hiddenCase1() {
        Q572 q572 = new Q572();
        boolean expectResult = true;
        boolean actualResult = q572.isSubtree(hiddenCase1Tree(), hiddenCase1SubTree());
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode q1Tree() {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(5);
        TreeNode leftLeftNode = new TreeNode(1);
        TreeNode leftRightNode = new TreeNode(2);
        root.left = left;
        root.right = right;
        left.left = leftLeftNode;
        left.right = leftRightNode;
        return root;
    }

    TreeNode q1SubTree() {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        return root;
    }

    TreeNode q2Tree() {
        TreeNode root = new TreeNode(3);
        TreeNode leftNode = new TreeNode(4);
        TreeNode rightNode = new TreeNode(5);
        TreeNode leftLeftNode = new TreeNode(1);
        TreeNode leftRightNode = new TreeNode(2);
        TreeNode leftRightLeftNode = new TreeNode(0);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = leftLeftNode;
        leftNode.right = leftRightNode;
        leftRightNode.left = leftRightLeftNode;
        return root;
    }

    TreeNode q2SubTree() {
        TreeNode root = new TreeNode(4);
        TreeNode leftNode = new TreeNode(1);
        TreeNode rightNode = new TreeNode(2);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    TreeNode hiddenCase1Tree() {
        TreeNode root = new TreeNode(1);
        return root;
    }

    TreeNode hiddenCase1SubTree() {
        TreeNode root = new TreeNode(1);
        return root;
    }

}
