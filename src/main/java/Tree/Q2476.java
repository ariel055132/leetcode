package Tree;

import java.util.ArrayList;
import java.util.List;

public class Q2476 {
    List<Integer> treeNodeList = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        inOrderTraversal(root);
        List<List<Integer>> result = new ArrayList<>();
        for (int query : queries) {
            int min = searchMin(treeNodeList, query);
            int max = searchMax(treeNodeList, query);
            result.add(List.of(min, max));
        }
        return result;
    }

    /**
     * InOrder Traversal
     * Left -> Node -> Right
     * List will be in ascending order
     *
     * @param node TreeNode
     */
    public void inOrderTraversal(TreeNode node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        treeNodeList.add(node.val);
        inOrderTraversal(node.right);
    }

    protected int searchMax(List<Integer> nums, int target) {
        int mx = -1;
        int left = 0;
        int right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) >= target) {
                mx = nums.get(mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return mx;
    }


    protected int searchMin(List<Integer> nums, int target) {
        int mn = -1;
        int left = 0;
        int right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) <= target) {
                mn = nums.get(mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return mn;
    }
}
