package Tree;

import java.util.ArrayList;
import java.util.List;

public class Q938 {
    List<Integer> treeNodeValues = new ArrayList<>();
    /**
     * Given the root node of a binary search tree and two integers low and high
     * return the sum of values of all nodes with a value in the inclusive range [low, high].
     *
     * Approach using the character of BST -> When performing inOrder traversal on a Binary Search Tree, the result is a sorted sequence in ascending order.
     * Then just need to traverse the list and find out the values in the inclusive range
     * @param root Root Node of a Binary Search Tree
     * @param low int
     * @param high int
     * @return sum of values of all nodes with a value in the inclusive range [low, high]
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        int result = 0;
        if (root == null) return result;
        inOrderTraversal(root);
        for (int val : treeNodeValues) {
            if (val >= low && val <= high) {
                result += val;
            }
        }
        return result;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        treeNodeValues.add(root.val);
        inOrderTraversal(root.right);
    }
}
