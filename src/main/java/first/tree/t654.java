package first.tree;

public class t654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left >= right){
            return  null;
        }
        int maxValueIndex = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > nums[maxValueIndex]){
                maxValueIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxValueIndex]);
        root.left = buildTree(nums, left, maxValueIndex);
        root.right = buildTree(nums, maxValueIndex + 1, right);
        return root;
    }
}
