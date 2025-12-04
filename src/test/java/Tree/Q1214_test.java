package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1214_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1214 q1214 = new Q1214();
        boolean expectResult = true;
        boolean actualResult = q1214.twoSumBSTs(tree1(), tree2(), 5);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q1214 q1214 = new Q1214();
        boolean expectResult = false;
        boolean actualResult = q1214.twoSumBSTs(tree3(), tree4(), 18);
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        node.left = node1;
        node.right = node2;
        return node;
    }

    TreeNode tree2() {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(3);
        node.left = node1;
        node.right = node2;
        return node;
    }

    TreeNode tree3() {
        TreeNode node = new TreeNode(0);
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(10);
        node.left = node1;
        node.right = node2;
        return node;
    }

    TreeNode tree4() {
        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(2);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        return node;
    }
}
