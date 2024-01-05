package org.example.node11;
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

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(0, head); // 伪头节点
        ListNode last = pre;    // 当前节点的上一个节点，初始为伪头节点
        ListNode node = head;    // 当前节点，初始为头节点
        int sameVal;    // 用于记录每次搜索的节点值
        int count;      // 统计节点值等于sameVal的节点数
        while(node != null){
            sameVal = node.val; // 记录当前搜索的节点值
            count = 1;  // 统计节点值
            while(node.next != null && node.next.val == sameVal){
                // 找到当前搜索的节点值的最后一个节点
                node = node.next;
                count++;
            }
            if(count == 1){
                last = node;    // 这个节点值只有一个节点，不为重复节点，将作为下一轮搜索的last
            }else{
                last.next = node.next;  // 这个节点值有重复节点，删除这些重复节点，即last连接到当前节点的下一个，last不变
            }
            node = node.next;   // 更新node
        }
        return pre.next;
    }
}


public class Main {
    public static void main(String[] args) {
        ListNode listnode =new ListNode(1);
        listnode.next=new ListNode(2);
        listnode.next.next=new ListNode(2);
        listnode.next.next.next=new ListNode(5);
        listnode.next.next.next.next=new ListNode(4);
        Solution solution = new Solution();
        ListNode listNode1 = solution.deleteDuplicates(listnode);
        System.out.println(listNode1.toString());
    }
}
