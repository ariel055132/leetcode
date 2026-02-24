package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1022_test {
    @Test
    @DisplayName("Traverse with tree1")
    void traverseTree1() {
        String str = "";
        Q1022 q1022 = new Q1022();
        q1022.traverse(tree1(), str);
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1022 q1022 = new Q1022();
        int expectResult = 22;
        int actualResult = q1022.sumRootToLeaf(tree1());
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
        TreeNode node = new TreeNode(1);
        TreeNode leftNode = new TreeNode(0);
        TreeNode rightNode = new TreeNode(1);
        TreeNode leftLeftNode = new TreeNode(0);
        TreeNode leftRightNode = new TreeNode(1);
        TreeNode rightLeftNode = new TreeNode(0);
        TreeNode rightRightNode = new TreeNode(1);
        node.left = leftNode;
        node.right = rightNode;
        leftNode.left = leftLeftNode;
        leftNode.right = leftRightNode;
        rightNode.left = rightLeftNode;
        rightNode.right = rightRightNode;
        return node;
    }
}
