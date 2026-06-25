package Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q272 {
    /**
     * Given the root of a binary search tree, a target value, and an integer k, return the k values in the BST that are closest to the target. You may return the answer in any order.
     * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
     * 
     * 1. Traverse the tree, add the root.val to arraylist
     * 2. Sort the arraylist with custom comparator (how close the elements are to target)
     * 3. Find the first k closest values. If tree has fewer than k values, returns all available values
     */
    List<Integer> list = new ArrayList<>();
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        inOrderTraversal(root);
        list.sort(Comparator.<Integer>comparingDouble(v -> Math.abs(v - target))
                .thenComparing(Integer::compare));
        int n = Math.min(k, list.size());
        return new ArrayList<>(list.subList(0, n));
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        list.add(root.val);
        inOrderTraversal(root.right);
    }
}
