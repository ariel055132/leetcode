package Blind75;

import Tree.TreeNode;

public class Q572 {
    /**
     * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
     *
     * @param root TreeNode (Tree)
     * @param subRoot TreeNode (Subtree)
     * @return boolean
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // If tree and subtree are null, return true
        if (root == null && subRoot == null) return true;
        // If one of them is null only, return false
        if (root == null || subRoot == null) return false;
        // Edge Case: If one node existed in root and subRoot, just need to compare the val of the root between them is same or not
        if (isSame(root, subRoot)) return true;
        // Traverse the left and right subtree of root
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    /**
     * Determine whether the left-subtree and right-subtree of root equals to subRoot or not
     *
     * @param subTree TreeNode (Left / Right subtree of tree)
     * @param subRoot TreeNode (Subtree)
     * @return boolean (subTree equals to subRoot)
     */
    public boolean isSame(TreeNode subTree, TreeNode subRoot) {
        // If tree and subtree are null, return true
        if (subTree == null && subRoot == null) return true;
        // If one of them is null only, return false
        if (subTree == null || subRoot == null) return false;
        // If value of node between subTree and subRoot are different, return false
        if (subTree.val != subRoot.val) return false;
        // Traverse the left subtree and right subtree
        return isSame(subTree.left, subRoot.left) && isSame(subTree.right, subRoot.right);
    }
}
