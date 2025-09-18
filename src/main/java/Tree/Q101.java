package Tree;

public class Q101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        else return isSameTree(root.left, root.right);
    }

    /**
     * Similar approach as isSameTree
     *
     * @param leftSubTree TreeNode
     * @param rightSubTree TreeNode
     * @return leftSubTree == rightSubTree
     */
    public boolean isSameTree(TreeNode leftSubTree, TreeNode rightSubTree) {
        if (leftSubTree == null && rightSubTree == null) {
            return true;
        }
        if ((leftSubTree == null && rightSubTree != null) || (leftSubTree != null && rightSubTree == null)) {
            return false;
        }
        if (leftSubTree.val != rightSubTree.val) {
            return false;
        }
        // As the question is comparing trees for symmetry or mirror structure
        // Therefore, we need to check if the left child of the first subtree matches the right child of the second subtree, and if the right child of the first subtree matches the left child of the second subtree.
        return isSameTree(leftSubTree.left, rightSubTree.right) && isSameTree(leftSubTree.right, rightSubTree.left);
    }
}
