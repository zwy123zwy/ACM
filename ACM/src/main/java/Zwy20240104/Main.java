package Zwy20240104;

import javax.swing.tree.TreeNode;

public class Main {
    public static void main(String[] args) {

    }
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
    /*
    * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
    每条从根节点到叶节点的路径都代表一个数字：
    例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
    计算从根节点到叶节点生成的 所有数字之和 。
    叶节点 是指没有子节点的节点
    * */
    public  static int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    public static int  dfs(TreeNode root,int presum){
        if(root==null) return 0;//初始为空，返回0；
        int result =presum*10+root.val;//初始不为空，取result;
        if(root.left==null&&root.right==null){
            return result;//初始不为空，左右节点不存在
        }else{
            //初始不为空，左右节点存在
            return dfs(root.left,result)+dfs(root.right,result);
        }
    }
    /*
    * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
    有效 二叉搜索树定义如下：
    节点的左子树只包含 小于 当前节点的数。
    节点的右子树只包含 大于 当前节点的数。
    所有左子树和右子树自身必须也是二叉搜索树。
    * */
    //递归调用
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    // 给定一个包含非负整数的 m x n 网格 grid ，
    // 请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小
    // 说明：每次只能向下或者向右移动一步。
    //
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        if(m==0||n==0){return 0;}
        int [][] dp=new int[m][n];//到达（M,N）的最小路经和
        //两个特例，作为基准边；
        dp[0][0]=grid[0][0];
        for(int i=1;i<m;i++){
            dp[i][0]=grid[i-1][0]+dp[i][0];;
        }//最左边到达的最小路径和
        for (int i = 1; i <n; i++) {
            dp[0][i]=grid[0][1]+dp[0][i];
        }//最上边到达的最小路径和
        for (int i = 1; i <m; i++) {
            for (int j = 1; j <n ; j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
