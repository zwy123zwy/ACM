package org.example.sdsf;
import java.util.*;
class ListNode{
    // 结点的值
    int val;

    // 下一个结点
    ListNode next;

    // 节点的构造函数(无参)
    ListNode() {
    }

    // 节点的构造函数(有一个参数)
    ListNode(int val) {
        this.val = val;
    }

    // 节点的构造函数(有两个参数)
     ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class Solution{
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummynode =new ListNode(0);
        dummynode.next=head;
        ListNode slow=dummynode;
        ListNode fast=dummynode;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        fast=fast.next;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummynode.next;
    }
}

public class Main{
    public static void main(String []args){
        ListNode listnode =new ListNode(1);
        listnode.next=new ListNode(2);
        listnode.next.next=new ListNode(3);
        listnode.next.next.next=new ListNode(5);
        listnode.next.next.next.next=new ListNode(4);
        Solution solution =new Solution();
        ListNode res=solution.removeNthFromEnd(listnode,2);
//        System.out.println(res.toString());
        while(res.next!=null){
            System.out.println("  "+res.val);
            res=res.next;
        }
    }
}