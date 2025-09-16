package Tree;

public class Q111 {
    /**
     * Given the binary tree, find its minimum depth.
     *
     * @param root TreeNode
     * @return minimum depth int
     */
    public int minDepth(TreeNode root) {
        /**
         * Do it recursively
         * Cases as follows:
         * 1. the whole tree is empty -> return 0
         * 2. both left and right subtree are empty -> return 1 (root)
         * 3. one of the subtree is empty -> return the height of another non-empty tree + 1
         * 4. Find the height of left-subtree and right-subtree respectively
         * 5. return Math.min(height of left-subtree, height of right-subtree) + 1
         */
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null && root.right != null) return minDepth(root.right) + 1;
        if (root.right == null && root.left != null) return minDepth(root.left) + 1;
        int leftSubtreeHeight = minDepth(root.left);
        int rightSubtreeHeight = minDepth(root.right);
        return Math.min(leftSubtreeHeight, rightSubtreeHeight) + 1;


    }
}
