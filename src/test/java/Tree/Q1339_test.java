package Tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1339_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1339 q1339 = new Q1339();
        int expectResult = 110;
        int actualResult = q1339.maxProduct(tree1());
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        TreeNode leftLeftNode = new TreeNode(4);
        TreeNode leftRightNode = new TreeNode(5);
        TreeNode rightLeftNode = new TreeNode(6);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = leftLeftNode;
        leftNode.right = leftRightNode;
        rightNode.left = rightLeftNode;
        return root;
    }
}
