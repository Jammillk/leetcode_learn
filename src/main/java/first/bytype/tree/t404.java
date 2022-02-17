package first.bytype.tree;

import java.util.Stack;

public class t404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum = root.left.val;
        }
        return sum + leftSum + rightSum;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.push(node);
                stack.push(null);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            } else {
                node = stack.pop();
                if (node.left != null && node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                }
            }
        }
        return sum;
    }
}
