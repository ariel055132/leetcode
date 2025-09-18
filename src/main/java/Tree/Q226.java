package Tree;

public class Q226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // Swap the left, and right to do the tree invert
        TreeNode tmp = invertTree(root.left);
        root.left=  invertTree(root.right);
        root.right = tmp;
        return root;
    }
}
