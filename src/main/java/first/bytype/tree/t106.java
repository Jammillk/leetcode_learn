package first.bytype.tree;

import java.util.HashMap;

public class t106 {
    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        post = postorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }

    private TreeNode buildTree(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
            return null;
        }
        int rootValue = post[postorderEnd];
        TreeNode root = new TreeNode(rootValue);
        int rightIndex = memo.get(rootValue);
        root.left = buildTree(inorderStart, rightIndex - 1, postorderStart, postorderStart + rightIndex - 1 - inorderStart);
        root.right = buildTree(rightIndex + 1, inorderEnd, postorderStart + rightIndex - inorderStart, postorderEnd - 1);
        return root;
    }
}
