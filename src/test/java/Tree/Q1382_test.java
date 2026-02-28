package Tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q1382_test extends BaseTreeTest {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q1382 q1382 = new Q1382();
        TreeNode actualResult = q1382.balanceBST(tree1());
        super.areTreesEqual(tree1ExpectResult(), actualResult);
    }

    
    TreeNode tree1() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.right = node2;
        node2.right = node3;
        node3.right = node4;
        return root;
    }

    TreeNode tree1ExpectResult() {
        TreeNode root = new TreeNode(2);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        root.left = root2;
        root.right = root3;
        root3.right = root4;
        return root;
    }
}
