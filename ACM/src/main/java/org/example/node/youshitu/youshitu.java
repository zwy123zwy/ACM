package org.example.node.youshitu;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
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
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> que=new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int len=que.size();
            for(int i=0;i<len;i++){
                TreeNode temp=que.poll();
                if(temp.left!=null){que.offer(temp.left);}
                if(temp.right!=null){que.offer(temp.right);}
                if(i==len-1){ans.add(temp.val);}
            }
        }
        return ans;
    }


}
public class youshitu {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        treeNode.left.right=new TreeNode(4);
        treeNode.right.right=new TreeNode(5);
        Solution solution = new Solution();
        List<Integer> integers = solution.rightSideView(treeNode);
        System.out.println(integers.toString());
    }
}
