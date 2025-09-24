package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q103_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q103 q103 = new Q103();
        List<List<Integer>> expectResult = new ArrayList<>();
        expectResult.add(List.of(3));
        expectResult.add(List.of(20, 9));
        expectResult.add(List.of(15, 7));
        List<List<Integer>> actualResult = q103.zigzagLevelOrder(tree1());
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        Q103 q103 = new Q103();
        List<List<Integer>> expectResult = new ArrayList<>();
        expectResult.add(List.of(1));
        TreeNode root = new TreeNode(1);
        List<List<Integer>> actualResult = q103.zigzagLevelOrder(root);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        Q103 q103 = new Q103();
        List<List<Integer>> expectResult = new ArrayList<>();
        List<List<Integer>> actualResult = q103.zigzagLevelOrder(null);
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
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
