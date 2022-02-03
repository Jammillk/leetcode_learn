package first.tree;

public class t104 {
    public static void main(String[] args) {
        t104 obj = new t104();
        TreeNode root5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root5.left = node4;
        root5.right = node6;
        node4.left = node1;
        node4.right = node2;
        obj.maxDepth(root5);
    }
    public int maxDepth(TreeNode root) {
        if (root == null){
            // 为空，就是没有！而不是1
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
