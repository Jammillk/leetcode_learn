package first.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class t98 {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Long inorder = Long.MIN_VALUE;
        // 中序为升序
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = (long) root.val;
            root = root.right;
        }
        return true;
    }

    private boolean valid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val > min || root.val < max) {
            return false;
        }
        return valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }
}
