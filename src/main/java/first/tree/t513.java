package first.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class t513 {
    int maxLen = Integer.MAX_VALUE;
    int maxLeftValue = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return maxLeftValue;
    }

    private void dfs(TreeNode root, int len) {
        if (root == null) {
            return;
        }
        // 下到叶子结点了！
        if (root.left == null && root.right == null) {
            // 到最底下的结点
            // 因为是先找左，所以能够实现
            if (len > maxLen) {
                maxLen = len;
                maxLeftValue = root.val;
            }
        }
        dfs(root.left, len + 1);
        dfs(root.right, len + 1);
    }

    public int findBottomLeftValue3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) {
                queue.offer(root.right);
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
        }
        return root.val;
    }


    public int findBottomLeftValue2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    res = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
