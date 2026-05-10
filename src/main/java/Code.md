# Code

## Matrix
1. Transpose Matrix
* Matrix flipped over its main diagonal.
* Switching the matrix's row and column indices
```java
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] result = new int[col][row];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                result[c][r] = matrix[r][c];
            }
        }
        return result;
    }

```

## Binary Search Tree
* TreeNode
```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
```
1. Pre-Order Traversal: root -> left -> right
```java
public static void preOrder(TreeNode node) {
    if (node == null) return;
    System.out.println(root.val);
    preOrder(root.left);
    preOrder(root.right);
}

```
2. In-Order Traversal: left -> root -> right
```java
public static void inOrder(TreeNode node) {
    if (node == null) return;
    inOrder(root.left);
    System.out.println(root.val);
    inOrder(root.right);
}
```
3. Post-Order Traversal: left -> right -> root
```java
public static void postOrder(TreeNode node) {
    if (node == null) return;
    postOrder(node.left);
    postOrder(node.right);
    System.out.println(root.val);
}
```