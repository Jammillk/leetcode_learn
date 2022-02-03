package first.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class t111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left == null && node.right == null) {
                    return res;
                }
            }
            res++;
        }
        return res;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 后序遍历！左右中
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        // 中就是处理逻辑
        if (root.left == null && root.right != null) {
            return 1 + rightDepth;
        }
        if (root.left != null && root.right == null) {
            return 1 + leftDepth;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }

}
