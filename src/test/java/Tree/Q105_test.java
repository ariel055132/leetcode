package Tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q105_test extends BaseTreeTest {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q105 q105 = new Q105();
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode actualResult = q105.buildTree(preOrder, inOrder);
        super.areTreesEqual(expectResultTree1(), actualResult);
    }

    TreeNode expectResultTree1() {
        TreeNode root = new TreeNode(3);
        TreeNode leftNode = new TreeNode(9);
        TreeNode rightNode = new TreeNode(20);
        TreeNode rightLeftNode = new TreeNode(15);
        TreeNode rightRightNode = new TreeNode(7);
        root.left = leftNode;
        root.right = rightNode;
        rightNode.left = rightLeftNode;
        rightNode.right = rightRightNode;
        return root;
    }
}
