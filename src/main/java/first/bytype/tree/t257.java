package first.bytype.tree;

import java.util.ArrayList;
import java.util.List;

public class t257 {
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, new StringBuilder());
        return res;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
            return ;
        }
        sb.append("->");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }
}
