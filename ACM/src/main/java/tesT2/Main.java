package tesT2;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }


};

class Solution {
    Node pre=null,cur=null;
    public Node treeToDoublyList(Node root) {
        if(root==null){return null;}
        dfs(root);
        return cur;
    }
    public void dfs(Node root){
        if(root==null){return ;}
        dfs(root.left);
        if(pre!=null){
            pre.right=root;
            root.left=pre;
            //移动位置
            pre=root;
        }else{
            // 将cur设置在位置上，移动位置，只有最左边的位置开始
            cur=root;
            pre=root;
        }

        dfs(root.right);
    }
}
public class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node root = new Node(2);
        root.left=new Node(1);
        root.right=new Node(3);
        Node node = solution.treeToDoublyList(root);

    }

}
