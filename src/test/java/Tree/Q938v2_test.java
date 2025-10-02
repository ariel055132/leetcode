package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q938v2_test {
    @Test
    @DisplayName("test 1")
    void test1() {
        Q938_v2 q938_v2 = new Q938_v2();
        int low = 7;
        int high = 15;
        int expectResult = 32;
        int actualResult = q938_v2.rangeSumBST(tree1(), low, high);
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(10);
        TreeNode leftNode = new TreeNode(5);
        TreeNode rightNode = new TreeNode(15);
        TreeNode leftLeftNode = new TreeNode(3);
        TreeNode leftRightNode = new TreeNode(7);
        TreeNode rightRightNode = new TreeNode(18);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = leftLeftNode;
        leftNode.right = leftRightNode;
        rightNode.right = rightRightNode;
        return root;
    }
}
