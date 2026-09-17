package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q298_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q298 q298 = new Q298();
        int expectResult = 3;
        int actualResult = q298.longestConsecutive(tree1());
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
        TreeNode node = new TreeNode(1);
        TreeNode rightNode = new TreeNode(3);
        TreeNode rightLeftNode = new TreeNode(2);
        TreeNode rightRightNode = new TreeNode(4);
        TreeNode rightRightRightNode = new TreeNode(5);
        node.right = rightNode;
        rightNode.left = rightLeftNode;
        rightNode.right = rightRightNode;
        rightRightNode.right = rightRightRightNode;
        return node;
    }
}
