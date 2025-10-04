package Tree;

import java.util.ArrayList;
import java.util.List;

public class Q230 {
    List<Integer> treeNodeList = new ArrayList<>();

    /**
     * Given the root of a binary search tree, and an integer k
     * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
     *
     * Approach:
     * 1. The inorder traversal of BST will generate an ascending order list
     * 2. Find the element from the list above by traversal.
     * @param root TreeNode
     * @param k index
     * @return the kth smallest value
     */
    public int kthSmallest(TreeNode root, int k) {
        int result = 0;
        if (root == null) return result;
        inOrderTraversal(root);
        for (int i = 0; i < k; i++) {
            result = treeNodeList.get(i);
        }
        return result;
    }

    protected void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        treeNodeList.add(root.val);
        inOrderTraversal(root.right);
    }
}
