package Tree;

public class Q112 {
    /**
     * Given the root of a binary tree and an integer targetSum
     *
     * @param root TreeNode
     * @param targetSum the sum need to fulfill
     * @return sum of all the values along root-to-leaf path equals targetSum
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // If the tree is null, return false
        // It is because it needs to have root-to-leaf path
        if (root == null) {
            return false;
        }
        // If the left-subtree and right-subtree are null, need to look up the value of root == targetSum
        // If equals, return true. Otherwise, return false
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        // Traverse the left-subtree and right-subtree respectively
        boolean isLeftSubtreeHasSum = hasPathSum(root.left, targetSum - root.val);
        boolean isRightSubtreeHasSum = hasPathSum(root.right, targetSum - root.val);
        // One of the subtree / Both subtree sum == targetSum, return true. Otherwise return false
        return isLeftSubtreeHasSum || isRightSubtreeHasSum;
    }
}
