package first.tree;

import java.util.*;
import java.util.stream.Collectors;

public class PostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(list);
        return list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

}
