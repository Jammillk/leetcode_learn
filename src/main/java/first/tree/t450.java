package first.tree;

public class t450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        TreeNode cur = root;
        // cur的父结点
        TreeNode curParent = null;
        while (cur != null) {
            if (cur.val == key) {
                break;
            }
            curParent = cur;
            if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (curParent == null) {
            return deleteOneNode(root);
        }
        // 判断要删的是左还是右
        // 因为现在cur指向要删除的结点
        if (curParent.left != null && curParent.left.val == key) {
            curParent.left = deleteOneNode(cur);
        }
        if (curParent.right != null && curParent.right.val == key) {
            curParent.right = deleteOneNode(cur);
        }
        return root;
    }

    /**
     * 删除一个结点
     *
     * @param root 要删除的结点
     * @return
     */
    private TreeNode deleteOneNode(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode cur = root.right;
        while (cur.left != null){
            cur = cur.left;
        }
        cur.left = root.left;
        return root.right;
    }

    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode2(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode2(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            root.val = cur.val;
            root.right = deleteNode2(root.right, cur.val);
        }
        return root;
    }

    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }
        if (root.val > key) {
            root.left = deleteNode1(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode1(root.right, key);
        }
        return root;
    }
}
