package Tree;

public class Q100 {
    /**
     * Function to check if the two binary trees are the same or not
     * Definition (Same):
     *
     * @param p Binary Tree1
     * @param q Binary Tree2
     * @return Binary Tree1 == Binary Tree2
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both binary trees are null, return true since they are identical.
        if (p == null && q == null) {
            return true;
        }
        // If only one of the binary trees is null, return false.
        if ((p != null && q == null) || (p == null && q != null)) {
            return false;
        }
        // If the values of the tree nodes in the two trees are different, return false.
        if (p.val != q.val) {
            return false;
        }
        // Recursively traverse the left subtrees of both tree1 and tree2, as well as the right subtrees of both tree1 and tree2.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
