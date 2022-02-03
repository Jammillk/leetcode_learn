package first.tree;

public class t572 {
    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if (root == null){
            return false;
        }
        boolean flag = false;
        if (root.val == subRoot.val){
            flag = isSameTree(root, subRoot);
        }
        return flag || isSubtree2(root.left, subRoot) || isSubtree2(root.right, subRoot);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null && q != null || p != null & q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) & isSameTree(p.right, q.right);
    }
}
