package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Q199_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q199 q199 = new Q199();
        List<Integer> expectResult = Arrays.asList(1, 3, 4);
        List<Integer> actualResult = q199.rightSideView(tree1());
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q199 q199 = new Q199();
        List<Integer> expectResult = Arrays.asList(1, 3, 4, 5);
        List<Integer> actualResult = q199.rightSideView(tree2());
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        TreeNode leftRightNode = new TreeNode(5);
        TreeNode rightRightNode = new TreeNode(4);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.right = leftRightNode;
        rightNode.right = rightRightNode;
        return root;
    }

    TreeNode tree2() {
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        TreeNode leftLeftNode = new TreeNode(4);
        TreeNode leftLeftLeftNode = new TreeNode(5);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = leftLeftNode;
        leftLeftNode.left = leftLeftLeftNode;
        return root;
    }
}
