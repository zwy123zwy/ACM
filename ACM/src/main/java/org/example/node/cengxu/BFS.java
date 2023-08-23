package org.example.node.cengxu;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
class Solution1 {
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        //checkFun01(root,0);
        checkFun02(root);

        return resList;
    }

    //DFS--递归方式
//    public void checkFun01(TreeNode node, Integer deep) {
//        if (node == null) return;
//        deep++;
//
//        if (resList.size() < deep) {
//            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
//            List<Integer> item = new ArrayList<Integer>();
//            resList.add(item);
//        }
//        resList.get(deep - 1).add(node.val);
//
//        checkFun01(node.left, deep);
//        checkFun01(node.right, deep);
//    }

    //BFS--迭代方式--借助队列
    public void checkFun02(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();

            while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                len--;
            }

            resList.add(itemList);
        }

    }
}
public class BFS {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);
        treeNode.left=new TreeNode(4);
        treeNode.right=new TreeNode(7);
        treeNode.left.left=new TreeNode(1);
        treeNode.left.right=new TreeNode(3);
        treeNode.right.left=new TreeNode(5);
        treeNode.right.right=new TreeNode(8);
        Solution1 solution1 = new Solution1();
        List<List<Integer>> lists = solution1.levelOrder(treeNode);
        System.out.println(lists.toString());
    }
}
