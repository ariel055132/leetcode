package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q112_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q112 q112 = new Q112();
        boolean expectResult = true;
        boolean actualResult = q112.hasPathSum(tree1(), 22);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q112 q112 = new Q112();
        boolean expectResult = false;
        boolean actualResult = q112.hasPathSum(tree2(), 5);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q112 q112 = new Q112();
        boolean expectResult = false;
        boolean actualResult = q112.hasPathSum(null, 0);
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(5);
        // Left-subtree
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(11);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        // Right-subtree
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(1);
        // Form the tree
        root.left = node1;
        root.right = node5;
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node5.left = node6;
        node5.right = node7;
        node7.right = node8;
        return root;
    }

    TreeNode tree2() {
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
