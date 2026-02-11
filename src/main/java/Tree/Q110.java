package Tree;

public class Q110 {
    /**
     * Given a binary tree, determine if it is height-balanced.
     * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
     *
     * Approaches is as following:
     *
     * @param root TreeNode
     * @return the tree is height-balanced
     */
    public boolean isBalanced(TreeNode root) {
        // If root is null (tree is null), that means the height of left-subtree and right-subtree is 0
        // Therefore, return true
        if (root == null) {
            return true;
        }
        // If the difference between the height of left-subtree and the height of right-subtree, return false
        if (Math.abs(calculateHeight(root.left) - calculateHeight(root.right)) > 1) {
            return false;
        }
        // Traverse the left-subtree and right-subtree
        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * Calculate the height of the tree
     * Same as maxDepth in Question 104
     *
     * @param root TreeNode
     * @return the height of the tree (+1 because of the root)
     */
    public int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSubTreeHeight = calculateHeight(root.left);
        int rightSubTreeHeight = calculateHeight(root.right);
        // + 1 because of the first tree node
        return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
    }


}
