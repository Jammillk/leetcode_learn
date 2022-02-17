package first.bytype.tree;

public class t108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree2(nums, 0, nums.length);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        // 没有结点了
        if (left >= right) {
            return null;
        }
        // 仅有一个结点
        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid);
        root.right = buildTree(nums, mid + 1, right);
        return root;
    }

    private TreeNode buildTree2(int[] nums, int left, int right) {
        if (right == left) {
            return new TreeNode(nums[left]);
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree2(nums, left, mid);
        root.right = buildTree2(nums, mid + 1, right);
        return root;
    }
}
