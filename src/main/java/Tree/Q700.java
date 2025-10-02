package Tree;

public class Q700 {
    /**
     * Given the root of a binary search tree (BST) and an integer val.
     * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
     * If such a node does not exist, return null.
     *
     * @param root TreeNode
     * @param val node's value
     * @return subtree rooted with that node / null
     */
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = new TreeNode();
        // If root is empty / null, just return null
        if (root == null) return null;
        // if root == val, just return root, no need to return left / right subtree
        if (root.val == val) {
            return root;
        }
        // just search left-subtree if val < root.val (according to the feature of BST, the left-subtree val always less than root val)
        if (val < root.val) {
            node = searchBST(root.left, val);
        }
        // just search right-subtree if val > root.val (according to the feature of BST, the right-subtree val always greater than root val)
        if (val > root.val) {
            node = searchBST(root.right, val);
        }
        return node;
    }
}
