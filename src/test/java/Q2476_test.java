import Tree.Q2476;
import Tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Q2476_test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q2476 q2476 = new Q2476();
        List<Integer> queries = List.of(2, 5, 16);
        List<List<Integer>> actualResult = q2476.closestNodes(tree1(), queries);
        for (List<Integer> i : actualResult) {
            System.out.println(i);
        }
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(6);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(13);
        TreeNode leftLeftNode = new TreeNode(1);
        TreeNode leftRightNode = new TreeNode(4);
        TreeNode rightLeftNode = new TreeNode(9);
        TreeNode rightRightNode = new TreeNode(15);
        TreeNode rightRightLeftNode = new TreeNode(14);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = leftLeftNode;
        leftNode.right = leftRightNode;
        rightNode.left = rightLeftNode;
        rightNode.right = rightRightNode;
        rightRightNode.left = rightRightLeftNode;
        return root;
    }
}
