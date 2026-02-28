package Tree;

import java.util.ArrayList;
import java.util.List;

public class Q1382 {
    List<Integer> treeValList = new ArrayList<>();
    
    /**
     * Given the root of a binary search tree, return a balanced binary search tree with the same node values. 
     * If there is more than one answer, return any of them.
     * A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
     * 
     * Algorithm:
     * 1. Perform in-order traversal to get a sorted list of node values
     * 2. Recursively build a balanced BST by selecting the middle element as root
     * 3. Elements before the middle form the left subtree
     * 4. Elements after the middle form the right subtree
     * 5. This ensures the tree remains balanced with O(log n) height
     * 
     * @param root TreeNode
     * @return Balanced binary tree
     */
    public TreeNode balanceBST(TreeNode root) {
        inOrderTraversal(root);
        TreeNode result = formTree(treeValList);
        return result;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        treeValList.add(root.val);
        inOrderTraversal(root.right);
    }

    public TreeNode formTree(List<Integer> treeValList) {
        // As list can become empty when forming tree, it would throw IndexOutOfBoundsException.
        // Therefore, add a base case to check if the list is null or empty before accessing elements.
        if (treeValList == null || treeValList.isEmpty()) {
            return null;
        }
        int midIndex = treeValList.size() / 2;
        TreeNode root = new TreeNode(treeValList.get(midIndex));
        List<Integer> leftTreeSubList = treeValList.subList(0, midIndex);
        root.left = formTree(leftTreeSubList);
        List<Integer> rightTreeSubList = treeValList.subList(midIndex+1, treeValList.size());
        root.right = formTree(rightTreeSubList);
        return root;

    }
}
