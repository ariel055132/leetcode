package Tree;

public class Q404 {
    public int sumOfLeftLeaves(TreeNode root) {
        // If the tree is null, return result as 0
        if (root == null) {
            return 0;
        }
        int result = 0; // variable to save the sum of left leaves
        // Find the left leaf, add the value of left leaf to result
        // Leaf definition from question is as follows
        // A leaf is a node with no children --> (root.left.left == null && root.left.right == null)
        if (root.left != null && (root.left.left == null && root.left.right == null)) {
            result += root.left.val;
        }
        // Traverse the left subtree and right-subtree respectively
        result += sumOfLeftLeaves(root.left);
        result += sumOfLeftLeaves(root.right);
        return result;
    }
}
