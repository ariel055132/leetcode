package Tree;

import java.util.Stack;

/**
 * Given the roots of two binary search trees, root1 and root2, return true if and only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer target.
 */
public class Q1214 {

    // Save the value of node of root1 and root2
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * Traverse both binary trees (root1 and root2)
     * Store node values from root1 in stack1 and from root2 in stack2
     * Iterate through stack1: For each value in stack1, calculate difference = target - value
     * Check stack2: Determine if the calculated difference exists in stack2
     * If found: Return true (valid pair exists)
     * If not found: Continue iterating through stack1
     * If no valid pair: Return false after checking all values
     *
     * @param root1
     * @param root2
     * @param target
     * @return
     */
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) return false;
        dfs(root1, stack1);
        dfs(root2, stack2);
        for (int ele : stack1) {
            int diff = target - ele;
            if (stack2.contains(diff)) {
                return true;
            }
        }
        return false;
    }

    private void dfs(TreeNode node, Stack<Integer> stack) {
        if (node == null) {
            return;
        }
        dfs(node.left, stack);
        stack.push(node.val);
        dfs(node.right, stack);
    }
}
