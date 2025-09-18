package Tree;

public class Q617 {
    /**
     *
     *
     * @param root1 TreeNode (Binary Tree 1)
     * @param root2 TreeNode (Binary Tree 2)
     * @return the merged binary tree of 1 and 2
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // If both trees are empty, just return null
        if (root1 == null && root2 == null) {
            return null;
        }
        // If tree1 is not null and tree2 is null, just return tree1
        if (root1 != null && root2 == null) {
            return root1;
        }
        // If tree1 is null and tree2 is not null, just return tree2
        if (root1 == null && root2 != null) {
            return root2;
        }
        // Create a node
        TreeNode node1 = new TreeNode();
        // sum nodes value up as the new value of the merge node
        node1.val = root1.val + root2.val;
        // Traverse the left-subtree and right-subtree of binary tree 1 and 2
        node1.left = mergeTrees(root1.left, root2.left);
        node1.right = mergeTrees(root1.right, root2.right);
        return node1;
    }
}
