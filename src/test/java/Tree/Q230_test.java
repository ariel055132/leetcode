package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q230_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q230 q230 = new Q230();
        int expectResult = 1;
        int actualResult = q230.kthSmallest(tree1(), 1);
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(3);
        TreeNode leftNode = new TreeNode(1);
        TreeNode rightNode = new TreeNode(4);
        TreeNode leftRightNode = new TreeNode(2);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.right = leftRightNode;
        return root;
    }
}
