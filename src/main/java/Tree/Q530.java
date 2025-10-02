package Tree;

import java.util.ArrayList;
import java.util.List;

public class Q530 {

    List<Integer> treeNodeValues = new ArrayList<>();

    /**
     * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
     *
     * The most common idea is to first inOrder traverse the tree and compare the delta between each of the adjacent values.
     * It's guaranteed to have the correct answer because it is a BST thus inOrder traversal values are sorted.
     *
     * @param root TreeNode
     * @return int (minimum absolute difference between the values of any two different nodes in the tree)
     */

    public int getMinimumDifference(TreeNode root) {
        int result = Integer.MAX_VALUE;
        if (root == null) return result;
        inOrderTraversal(root);
        for (int i = 1; i < treeNodeValues.size(); i++) {
            int currentResult = Math.abs(treeNodeValues.get(i) - treeNodeValues.get(i-1));
            result = Math.min(result, currentResult);
        }
        return result;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return ;
        }
        inOrderTraversal(root.left);
        treeNodeValues.add(root.val);
        inOrderTraversal(root.right);
    }
}
