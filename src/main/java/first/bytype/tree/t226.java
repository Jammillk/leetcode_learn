package first.bytype.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class t226 {
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode temp = node.right;
                node.right = node.left;
                node.left = temp;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {
        t226 obj = new t226();
        TreeNode root4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        root4.left = node2;
        root4.right = node7;
        node2.left = node1;
        node2.right = node3;
        node7.left = node6;
        node7.right = node9;
        obj.invertTree2(root4);
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 前后序遍历都可以
        invertTree2(root.left);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 注：中序会翻两次！
        invertTree2(root.right);
        return root;
    }
}
