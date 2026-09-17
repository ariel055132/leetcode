package Tree;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q366_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q366 q366 = new Q366();
        List<List<Integer>> expectResult = List.of(
            List.of(4, 5, 3),
            List.of(2),
            List.of(1)
        );
        List<List<Integer>> actualResult = q366.findLeaves(tree1());
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        return root;
    }
}
