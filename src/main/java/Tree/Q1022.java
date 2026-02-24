package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. 
 * Return the sum of these numbers.
 */

public class Q1022 {
    List<String> nodeList = new ArrayList<>();
    // Use DFS to traverse all root-to-leaf paths (node.val -> node.left -> node.right)
    // Build binary strings by appending node values during traversal
    // Convert each binary string to decimal and return the sum
    public int sumRootToLeaf(TreeNode root) {
        int result = 0;
        traverse(root, "");
        // Traverse the binary form string in nodeList, calculate the result in decimal form and do the summation.
        for (int i = 0; i < nodeList.size(); i++) {
            result += Integer.parseInt(nodeList.get(i), 2);
        }
        return result;
    }

    public void traverse(TreeNode node, String str) {
        if (node == null) return;
        // Append current node's value to the path
        str += Integer.toString(node.val);  
        if (node.left == null && node.right == null) {
            // Leaf node - add complete binary path to list
            nodeList.add(str);
            return;
        }
        // Traverse left-subtree / leaf
        traverse(node.left, str);
        // Traverse right-subtree / leaf
        traverse(node.right, str);
    }
}
