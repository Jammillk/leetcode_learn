package first.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class t530 {
    private int result = Integer.MAX_VALUE;
    private TreeNode preNode = null;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return ;
        }
        dfs(root.left);
        if (preNode != null){
            result = Math.min(result, Math.abs(root.val - preNode.val));
        }
        preNode = root;
        dfs(root.right);
    }

}
