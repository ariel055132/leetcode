package Tree;

import java.util.Arrays;

public class Q105 {
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (inOrder.length == 0) return null;

        int rootVal = preOrder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIndexInOrder = findIndex(inOrder, rootVal);
        int[] leftSubTreeInOrder = Arrays.copyOfRange(inOrder, 0, rootIndexInOrder);
        int[] rightSubTreeInOrder = Arrays.copyOfRange(inOrder, rootIndexInOrder + 1, inOrder.length);

        int[] leftSubTreePreOrder = Arrays.copyOfRange(preOrder, 1, 1 + leftSubTreeInOrder.length);
        int[] rightSubTreePreOrder = Arrays.copyOfRange(preOrder, 1 + leftSubTreeInOrder.length, preOrder.length);

        root.left = buildTree(leftSubTreePreOrder, leftSubTreeInOrder);
        root.right = buildTree(rightSubTreePreOrder, rightSubTreeInOrder);

        return root;
    }

    private int findIndex(int[] inOrder, int target) {
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
