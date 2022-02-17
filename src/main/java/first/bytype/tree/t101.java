package first.bytype.tree;

public class t101 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null && right != null || left != null && right == null) {
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
