package org.example;

import java.util.Stack;

class Solution1 {
    TreeNode pre;
    Stack<TreeNode> stack;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        stack = new Stack<>();
        TreeNode cur = root;
        int result = Integer.MAX_VALUE;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur); // 将访问的节点放进栈
                cur = cur.left; // 左
            }else {
                cur = stack.pop();
                if (pre != null) { // 中
                    result = Math.min(result, cur.val - pre.val);
                }
                pre = cur;
                cur = cur.right; // 右
            }
        }
        return result;
    }
}
public class getMinimumDifference {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        treeNode.left=new TreeNode(4);
        treeNode.left.left=new TreeNode(1);
        treeNode.left.right=new TreeNode(7);
        treeNode.right=new TreeNode(10);
//        treeNode.right.left=new TreeNode(3);
        treeNode.right.right=new TreeNode(15);
        Solution1 solution1 = new Solution1();
        int minimumDifference = solution1.getMinimumDifference(treeNode);
        System.out.println(minimumDifference);
    }
}
