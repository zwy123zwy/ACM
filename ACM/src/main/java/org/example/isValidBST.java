package org.example;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }
 }
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        if(root != null)
            stack.add(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.peek();
            if(curr != null){
                stack.pop();
                if(curr.right != null)
                    stack.add(curr.right);
                stack.add(curr);
                stack.add(null);
                if(curr.left != null)
                    stack.add(curr.left);
                System.out.println(stack.toString());
            }else{
                stack.pop();
                TreeNode temp = stack.pop();
                if(pre != null && pre.val >= temp.val)
                    return false;
                pre = temp;
            }
        }
        return true;
    }
}
public class isValidBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left=new TreeNode(1);
        treeNode.right=new TreeNode(4);
        treeNode.right.left=new TreeNode(3);
        treeNode.right.right=new TreeNode(6);
        Solution solution = new Solution();
        boolean validBST = solution.isValidBST(treeNode);
        System.out.println(validBST);
    }
}
