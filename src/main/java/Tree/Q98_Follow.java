package Tree;

public class Q98_Follow {
    int previousNodeValue = Integer.MIN_VALUE;
    /**
     * Do we have a more space-optimized solution
     *
     * InOrder Traversal (LVR)
     *
     * @param root TreeNode
     * @return boolean (it is a valid BST??)
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val <= previousNodeValue) return false;
        previousNodeValue = root.val;
        if (!isValidBST(root.right)) return false;
        return true;
    }
}
