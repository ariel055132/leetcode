package Tree;

import java.util.ArrayList;
import java.util.List;

public class Q270 {
    List<Integer> list = new ArrayList<>();
    /**
     * Given the root of a binary search tree and a target value.
     * Return the value in the BST that is closest to the target.
     * If there are multiple answers, print the smallest
     * 
     * Solution:
     * 1. InOrder Traversal the BST to get a sorted list
     * (Note): In-Order traversal of a BST will get a sorted list in ascending order
     * 2. Iterate through the list and find the value that is closest to the target
     * 3. Return the value
     * 
     * @param root
     * @param target
     * @return
     */
    public int closestValue(TreeNode root, double target) {
        inOrderTraversal(root);
        // The value in the BST that is closest to the target
        int best = list.get(0); 
        // Distance difference that is closest to the target 
        double bestDist = Math.abs(best - target);
        for (int i = 1; i < list.size(); i++) {
            // Obtain the value from the list
            int v = list.get(i);
            // Calculate the distance difference between the value and the target
            double d = Math.abs(v - target);
            // If the distance difference is less than the best distance difference, or the distance difference is equal to the best distance difference and the value is less than the best value, then update the best value and the best distance difference
            if (d < bestDist || (d == bestDist && v < best)) {
                best = v;
                bestDist = d;
            }
        }
        return best;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        list.add(root.val);
        inOrderTraversal(root.right);
    }
}
