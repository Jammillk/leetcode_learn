package first.tree;

public class t222 {
    // 完全二叉树，性质！
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        // 两边高度一样，则左是满二叉树
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1 + 1 + countNodes(root.right);
        } else {// 高度不等，则左边多一些，但是右边是满的
            return (1 << rightDepth) - 1 + 1 + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }
}
