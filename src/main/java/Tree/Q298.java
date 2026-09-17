package Tree;

public class Q298 {
    private int result = 0;
    /**
     * Given the root of a binary tree, return the length of the longest consecutive sequence path.
     * A consecutive sequence path is a path where the values increase by one along the path.
     * Note that the path can start at any node in the tree, and you cannot go from a node to its parent in the path.
     * 
     * depth-first search (DFS), carrying the current consecutive length from parent to child.
     * 
     * @param root
     * @return
     */
    public int longestConsecutive(TreeNode root) {
        // The root has no parent. result stores the longest consecutive path found anywhere.
        dfs(root, null,0);
        return result;
    }

    private void dfs(TreeNode node, TreeNode parent, int length) {
        if (node == null) return;
        // If the current node continues the consecutive sequence, extend its length. 
        // Otherwise, start a new sequence containing only this node.
        if (parent != null && node.val == parent.val + 1) length++;
        else length = 1;
        // The current node becomes the children’s parent. Java passes the primitive int length by value, so changes within one child’s recursion do not affect the other child.
        result = Math.max(result, length);
        dfs(node.left, node, length);
        dfs(node.right, node, length);
    }
}
