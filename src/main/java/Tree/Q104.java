package Tree;

public class Q104 {
    public int maxDepth(TreeNode root) {
        // If the whole tree is empty, return 0
        if (root == null) {
            return 0;
        }
        // Traverse the left-subtree, calculate the height of left-subtree
        int left = maxDepth(root.left);
        // Traverse the right-subtree, calculate the height of right-subtree.
        int right = maxDepth(root.right);
        // +1 because need to add the root
        return Math.max(left, right) + 1;
    }
}
