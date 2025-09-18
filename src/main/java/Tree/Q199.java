package Tree;

import java.util.ArrayList;
import java.util.List;

public class Q199 {
    /**
     * Return the right side view of a binary tree
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // Return result;
        dfs(root, result, 0);
        return result;
    }

    /**
     * Perform a depth-first search starting from the root
     *
     * @param root TreeNode
     * @param result List<Integer>
     * @param depth int
     */
    public void dfs(TreeNode root, List<Integer> result, int depth) {
        // If the current node is null, just return
        if (root == null) {
            return;
        }
        // If depth == result.size(), it means this is the first node visited at the depth, so add the node's value to result
        if (depth == result.size()) {
            result.add(root.val);
        }
        // Traverse the right subtree first to ensure rightmost nodes are added before the left ones
        // Then traverses the left subtree
        dfs(root.right, result, depth + 1);
        dfs(root.left, result, depth + 1);
    }
}
