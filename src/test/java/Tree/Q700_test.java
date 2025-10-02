package Tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q700_test extends BaseTreeTest{
    @Test
    @DisplayName("Test 1")
    void test1() {
        Q700 q700 = new Q700();
        TreeNode expectResult = expectTree1();
        TreeNode actualResult = q700.searchBST(tree1(), 2);
        super.areTreesEqual(expectResult, actualResult);
    }


    TreeNode tree1() {
        TreeNode root = new TreeNode(4);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(7);
        TreeNode leftLeftNode = new TreeNode(1);
        TreeNode leftRightNode = new TreeNode(3);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = leftLeftNode;
        leftNode.right = leftRightNode;
        return root;
    }

    TreeNode expectTree1() {
        TreeNode root = new TreeNode(2);
        TreeNode leftNode = new TreeNode(1);
        TreeNode rightNode = new TreeNode(3);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
