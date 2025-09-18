package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q617_test extends BaseTreeTest {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q617 q617 = new Q617();
        TreeNode expectResult = summedBinaryTree1();
        TreeNode actualResult = q617.mergeTrees(binaryTree1(), binaryTree2());
        Assertions.assertTrue(super.areTreesEqual(expectResult, actualResult));
    }

    TreeNode binaryTree1() {
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(3);
        TreeNode rightNode = new TreeNode(2);
        TreeNode leftLeftNode = new TreeNode(5);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = leftLeftNode;
        return root;
    }

    TreeNode binaryTree2() {
        TreeNode root = new TreeNode(2);
        TreeNode leftNode = new TreeNode(1);
        TreeNode rightNode = new TreeNode(3);
        TreeNode leftRightNode = new TreeNode(4);
        TreeNode rightRightNode = new TreeNode(7);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.right = leftRightNode;
        rightNode.right = rightRightNode;
        return root;
    }

    TreeNode summedBinaryTree1() {
        TreeNode root = new TreeNode(3);
        TreeNode leftNode = new TreeNode(4);
        TreeNode rightNode = new TreeNode(5);
        TreeNode leftLeftNode = new TreeNode(5);
        TreeNode leftRightNode = new TreeNode(4);
        TreeNode rightRightNode = new TreeNode(7);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = leftLeftNode;
        leftNode.right = leftRightNode;
        rightNode.right = rightRightNode;
        return root;
    }
}
