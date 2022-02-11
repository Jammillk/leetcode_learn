package first.tree;

import java.util.*;
import java.util.stream.Collectors;

public class t501 {
    List<Integer> list = new ArrayList<>();
    TreeNode pre = null;
    int count = 0;
    int maxCount = 0;

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        // 暴力法
        List<Integer> list = new ArrayList<>();
        ddfs(root);
        List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .collect(Collectors.toList());
        list.add(mapList.get(0).getKey());
        for (int i = 1; i < mapList.size(); i++) {
            if (mapList.get(i - 1).getValue() == mapList.get(i).getValue()){
                list.add(mapList.get(0).getKey());
            }else{
                break;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void ddfs(TreeNode root) {
        if (root == null) {
            return;
        }
        ddfs(root.left);
        ddfs(root.right);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
    }


    public int[] findMode3(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre == null || pre.val != root.val) {
                count = 1;
            } else {
                count++;
            }
            if (count > maxCount) {
                maxCount = count;
                list.clear();
                list.add(root.val);
            } else if (count == maxCount) {
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
