package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q226_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q226 q226 = new Q226();
        TreeNode expectResult = invertedTree1();
        TreeNode actualResult = q226.invertTree(tree1());
        Assertions.assertTrue(areTreesEqual(expectResult, actualResult));
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q226 q226 = new Q226();
        TreeNode expectResult = invertedTree2();
        TreeNode actualResult = q226.invertTree(tree2());
        Assertions.assertTrue(areTreesEqual(expectResult, actualResult));
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(4);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(7);
        TreeNode leftLeftNode = new TreeNode(1);
        TreeNode leftRightNode = new TreeNode(3);
        TreeNode rightLeftNode = new TreeNode(6);
        TreeNode rightRightNode = new TreeNode(9);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = leftLeftNode;
        leftNode.right = leftRightNode;
        rightNode.left = rightLeftNode;
        rightNode.right = rightRightNode;
        return root;
    }

    TreeNode invertedTree1() {
        TreeNode root = new TreeNode(4);
        TreeNode leftNode = new TreeNode(7);
        TreeNode rightNode = new TreeNode(2);
        TreeNode leftLeftNode = new TreeNode(9);
        TreeNode leftRightNode = new TreeNode(6);
        TreeNode rightLeftNode = new TreeNode(3);
        TreeNode rightRightNode = new TreeNode(1);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = leftLeftNode;
        leftNode.right = leftRightNode;
        rightNode.left = rightLeftNode;
        rightNode.right = rightRightNode;
        return root;
    }

    TreeNode tree2() {
        TreeNode root = new TreeNode(2);
        TreeNode leftNode = new TreeNode(1);
        TreeNode rightNode = new TreeNode(3);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    TreeNode invertedTree2() {
        TreeNode root = new TreeNode(2);
        TreeNode leftNode = new TreeNode(3);
        TreeNode rightNode = new TreeNode(1);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    // Helper function to compare trees are equal
    private boolean areTreesEqual(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;
        return tree1.val == tree2.val &&
                areTreesEqual(tree1.left, tree2.left) &&
                areTreesEqual(tree1.right, tree2.right);
    }
}
