package first.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class t501 {
    List<Integer> list = new ArrayList<>();
    TreeNode pre = null;
    int count = 0;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre == null || pre.val != root.val){
                count = 1;
            }else{
                count++;
            }
            if(count > maxCount){
                maxCount = count;
                list.clear();
                list.add(root.val);
            }else if(count == maxCount){
                list.add(root.val);
            }
            pre = root;
            root = root.right;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] findMode2(TreeNode root) {
        dfs(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
//        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        // 逻辑
        int rootValue = root.val;
        if (pre == null || rootValue != pre.val) {
            count = 1;
        } else {
            count++;
        }
        if (count > maxCount) {
            list.clear();
            ;
            list.add(root.val);
            maxCount = count;
        } else if (count == maxCount) {
            list.add(root.val);
        }
        pre = root;

        dfs(root.right);
    }
}
