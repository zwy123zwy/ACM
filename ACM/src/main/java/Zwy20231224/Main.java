package Zwy20231224;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
    /*给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
    例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
    示例 1：
    输入：nums = [10,9,2,5,3,7,101,18]
    输出：4
    解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 */
    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        int [] arr=new int[len];
        Arrays.fill(arr, 1);
        for (int i=1; i<len;i++) {
            for(int j=0; j<i;j++) {
                if(nums[i]>nums[j]) {
                    arr[i]=Math.max(arr[i],arr[j]+1);
                }
            }
        }
        Arrays.sort(arr);
        return  arr[len-1];

    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode mid=getMidListNode(head);
        ListNode prev=head;
        ListNode cur=mid.next;
        mid.next=null;
        mergeListNode(prev, cur);
        //return prev;
    }
    public ListNode getMidListNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public void reverseListNode(ListNode head){
        ListNode prev=null,cur=head,tmp=null;
        while(cur!=null){
            tmp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=tmp;
        }
    }
    public void mergeListNode(ListNode l1,ListNode l2){
        ListNode l1Tmp;
        ListNode l2Tmp;
        while(l1!=null&&l2!=null){
            l1Tmp=l1.next;
            l2Tmp=l2.next;
            l1.next=l2;
            l1=l1Tmp;
            l2.next=l1;
            l2=l2Tmp;
        }
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int []>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int start=intervals[0][0];
        int end=intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i][0]>end) {
                list.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }else{
                end=Math.max(end,intervals[i][1]);
            }
        }
        return list.toArray(new int[list.size()][]);

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        Deque<TreeNode> stack=new LinkedList<>();
        stack.offer(root);
        while(!stack.isEmpty()){
            //stack.offer(stack.p)
            int len=stack.size();
            for(int i=0;i<len;i++){
                TreeNode tree=stack.pollFirst();
                if(tree.left!=  null)stack.add(tree.left);
                if (tree.right!=null)stack.add(tree.right);
                if(i==len-1) res.add(stack.size());
            }
        }
        return res;
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1,head);
        ListNode pre=dummy;
        ListNode cur=head;
        int count;
        while(cur!=null){
            count=1;
            while(cur.next!=null&&cur.next.val==cur.val){
                cur=cur.next;
                count++;
            }
            if(count==1){
                pre=cur;
            }else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return dummy.next;
    }
    public String reverseWords(String s) {
        s=s.trim();
        String[] words=s.split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(int i=words.length-1; i>0; i--){
            sb.append(words[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
