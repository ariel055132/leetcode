package Tree;

import java.util.ArrayList;

public class Q98 {
    ArrayList<Integer> inOrderTreeList = new ArrayList<>();
    /**
     * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
     * A valid BST is defined as follows:
     * 1. The left subtree of a node contains only nodes with keys strictly less than the node's key.
     * 2. The right subtree of a node contains only nodes with keys strictly greater than the node's key.
     * 3. Both the left and right subtrees must also be binary search trees.
     *
     * Approach:
     * InOrder Traversal: LVR (left -> val -> right)
     * Using inorder traversal can create an ascending order of TreeNode val if the tree is a valid BST
     * Therefore, we can create an arraylist, traverse left subtree, append the val, traverse right subtree
     * Traverse the arraylist and find that whether the elements are perfectly sorted
     * If yes -> return true
     * Otherwise -> return false
     *
     * @param root TreeNode (Binary Tree)
     * @return boolean (it is a valid BST?)
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        inOrderTraversal(root);
        for (int i = 1; i < inOrderTreeList.size(); i++) {
            if (inOrderTreeList.get(i) <= inOrderTreeList.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Inorder Traversal
     * Left -> Value (Mid) -> Right
     *
     * @param root TreeNode
     */
    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        inOrderTreeList.add(root.val);
        inOrderTraversal(root.right);
    }
}
