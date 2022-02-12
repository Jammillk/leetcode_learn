package first.tree;

public class t701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        TreeNode cur = root;
        TreeNode parent = root;
        while (cur != null){
            parent = cur;
            if (cur.val < val){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
        TreeNode node = new TreeNode(val);
        if (parent.val > val){
            parent.left = node;
        }else{
            parent.right = node;
        }
        return root;
    }

        public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        if (root.val < val){
            root.right = insertIntoBST2(root.right, val);
        }
        if (root.val > val){
            root.left = insertIntoBST2(root.left, val);
        }
        return root;
    }
}
