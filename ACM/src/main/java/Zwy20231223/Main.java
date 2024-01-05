package Zwy20231223;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Main {
    /*
    * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    你可以按任意顺序返回答案。
    示例 1：
    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
    */
    public static void main(String[] args) {
        int [] nums ={3,2,1,5,6,4};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }
    public static int [] test(int [] arr,int target){
        //List<Integer> res=new ArrayList<>();
        int [] res = new int[2];
        for (int i=0; i< arr.length-1; i++){
            for (int j=i+1;j<arr.length; j++){
                if(arr[j]+arr[i]==target){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return res;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){return l2;}
        if(l2==null){return l1;}
        ListNode tmp=new ListNode(-1);
        ListNode res=tmp;
        int carry=0;
        while(l1==null||l2==null){
            int v1=l1==null?0:l1.val;
            int v2=l2==null?0:l2.val;
            int sum=v1+v2+carry;
            carry=sum/10;
            res.next=new ListNode(sum%10);
            res=res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(carry!=0){res.next=new ListNode(carry);}
        return tmp.next;
    }
    /*给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
    示例 1:
    输入: s = "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:
    输入: s = "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例 3:
    输入: s = "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
         请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。*/
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<Character>();
        int left=0,right=0;
        int max=0;
        int length=s.length();
        while(right<length){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
            max= Math.max(max, set.size());
        }
        return  max;
    }
    /*给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    示例 1：
    输入：head = [1,2,3,4,5], n = 2
    输出：[1,2,3,5]*/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp=head;
        int count=0;
        while(tmp!=null){
            tmp=tmp.next;
            count++;
        }
        if(count<n){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while(fast.next!=null){
             slow=slow.next;
             fast=fast.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
    /*给你一个字符串 s，找到 s 中最长的回文子串。
    如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
    示例 1：
    输入：s = "babad"
    输出："bab"
    解释："aba" 同样是符合题意的答案。
    示例 2：
    输入：s = "cbbd"
    输出："bb"*/
    public String longestPalindrome(String s) {
        if(s.isEmpty()){
            return s;
        }
        String res="";
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length()-1;j++){
                String r=s.substring(i,j);
                String k=new StringBuilder(r).reverse().toString();
                if(r.equals(k)){
                    res=r;
                }
            }
        }
        return  res;
    }
    /*给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    示例 1：
    输入：digits = "23"
    输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]*/
//    public  List<String> list = new ArrayList<>();
//    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, numString, 0);
        return list;
    }
    public void backTracking(String digits, String [] numString,int num){
        if(num==digits.length()){
            list.add(sb.toString());
            return ;
        }
        String str=numString[digits.charAt(num)-'0'];
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            backTracking(digits,numString,num+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    /*
    * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    示例 1：
    输入：n = 3
    输出：["((()))","(()())","(())()","()(())","()()()"]
    示例 2：
    输入：n = 1
    输出：["()"]*/
  public  List<String> list = new ArrayList<>();
  StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        back(0,0,n);
        return list;
    }
    public  void back(int left, int right, int n) {
        if(left==n&&right==n) {
            list.add(sb.toString());
            return; //
        }
        if(left<n){
            sb.append('(');
            back(left+1,right,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left){
            sb.append(')');
            back(left,right+1,n);
            sb.deleteCharAt(sb.length()-1);
        }

    }
    List<Integer> list1 = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
           bfs(candidates,0,target);
           return res;
    }
    public void bfs(int[] candidates,int idx,int target) {
        if(target==0){
            res.add(list1);
            return ;
        }
        for(int i=idx;i<candidates.length;i++){
            if(target-candidates[i]>=0) {
                list1.add(candidates[i]);
                bfs(candidates, i, target - candidates[i]);
                list1.remove(candidates[i]);
            }
        }
    }
//    LRU
    class LRUcache{
        class Node{
            int key,value;
            Node prev,next;
            //构造初始化
            Node(int key,int value){
                this.key=key;
                this.value=value;
            }
        }
        private final int capacity;
        private final Node dummy=new Node(0,0);
        //哈希表映射
        private final  Map<Integer,Node> map=new HashMap<Integer,Node>();
        //LRUCache初始化
        public LRUcache(int capacity) {
            this.capacity = capacity;
            dummy.prev = dummy;
            dummy.next = dummy;
        }
        public int get(int key){
            Node node = getNode(key);
            return node != null ? node.value:-1;
        }
        public void put(int key, int value){
            Node node = getNode(key);
            if (node != null) {
                node.value = value;
                return;
            }
            node = new Node(key, value); //
            map.put(key, node);
            pushFront(node); // 放在最上面
            if(map.size()>capacity){
                Node tmp=dummy.prev;
                map.remove(tmp.key);
                remove(tmp);
            }
        }
        public Node getNode(int key) {
            //如果没有该值
            if(!map.containsKey(key)){
                return null;
            }
            Node node = map.get(key);
            //移除该节点
            remove(node);
            //将该节点放在最前面
            pushFront(node);
            return node;
        }
        public void remove(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }
        public void pushFront(Node node){
            node.prev=dummy;
            node.next=dummy.next;
            node.prev.next=node;
            node.next.prev=node;
        }
    }
    //数组中第K个最大元素
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<k; i++) {
            queue.offer(nums[i]);
            System.out.println(queue.peek());
        }
        for(int i=k; i<nums.length; i++) {
            if(nums[i]> queue.peek()){
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
//二叉树
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

    List<List<Integer>> resl=new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        checkFun(root);
        return resl;
    }
    public void checkFun(TreeNode root) {
        if (root==null) return;
        Queue<TreeNode> que=new LinkedList<>();
        boolean flag=false;
        que.offer(root);
        while(!que.isEmpty()) {
            List<Integer> path=new ArrayList<Integer>();
            int len= que.size();
            while(len-->0){
                TreeNode node=que.poll();
                path.add(node.val);
                if(node.left!=null){que.offer(node.left);}
                if(node.right!=null){que.offer(node.right);}
            }
            if(flag){
                Collections.reverse(path);
                resl.add(path);
            }else{
                resl.add(path);
            }
            flag=!flag;
        }
    }
//    二叉树最近公共最近祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { // 递归结束条件
            return root;
        }

        // 后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) { // 若未找到节点 p 或 q
            return null;
        }else if(left == null && right != null) { // 若找到一个节点
            return right;
        }else if(left != null && right == null) { // 若找到一个节点
            return left;
        }else { // 若找到两个节点
            return root;
        }
    }
//    岛屿数量
    public int numIslands(char[][] grid) {
        if(grid == null||grid.length==0){
            return 0;
        }
        int row =grid.length;
        int column =grid[0].length;
        int num=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j]=='1'){
                    num++;
                    dfs(grid,i,j);
                }
            }
        }
        return num;
    }
    public void  dfs(char[][]grid,int i,int j){
        if(i<0||j<0||grid[i][j]=='0'||i>=grid.length||j>=grid[0].length){
            return;
        }
        grid[i][j] ='0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode prev =dummy;
        for(int i=0;i<left-1;i++){
            prev=prev.next;
        }//去翻链表之前的节点
        ListNode back=prev;
        for(int i=0;i<right-left+1;i++){
            back=back.next;
        }//back 中间字符串的最后一项
        ListNode mid=prev.next;
        ListNode cur=back.next;
        prev.next=null;
        back.next=null;
        reverseNode(mid);
        prev.next=back;
        mid.next=cur;
        return dummy.next;
    }
    public void reverseNode(ListNode head){
        ListNode prev=null,cur=head,tmp=null;
        while(cur!=null){
            tmp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=tmp;
        }
        //return prev;
    }
}