package Tree;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q272_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q272 q272 = new Q272();
        TreeNode root = tree1();
        double target = 3.714286;
        int k = 2;
        List<Integer> expectResult = List.of(4, 3);
        List<Integer> actualResult = q272.closestKValues(root, target, k);
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(4);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(5);
        TreeNode leftLeftNode = new TreeNode(1);
        TreeNode leftRightNode = new TreeNode(3);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = leftLeftNode;
        leftNode.right = leftRightNode;
        return root;
    }
}
