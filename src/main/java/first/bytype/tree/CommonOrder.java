package first.bytype.tree;

import java.util.*;

public class CommonOrder {
    public static void main(String[] args) {
        CommonOrder commonOrder = new CommonOrder();
        TreeNode root5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root5.left = node4;
        root5.right = node6;
        node4.left = node1;
        node4.right = node2;
        commonOrder.inorder(root5);
    }

    /**
     *
     */
    private List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        /*顺序变更的地方*/
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node != null){
                if (node.right != null) {
                    stack.push(node.right);
                }
                // 访问了，但是还没处理
                stack.push(node);
                stack.push(null);
                if (node.left != null) {
                    stack.push(node.left);
                }
            }else{
                node = stack.pop();
                list.add(node.val);
            }
        }
        return list;
    }

    private List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node != null){
                stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                stack.push(node);
                stack.push(null);
            }else{
                stack.pop();
                node = stack.pop();
                list.add(node.val);
            }
        }
        return list;
    }

    private List<Integer> postorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        return list;
    }
}
