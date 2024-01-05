package heap.midNum;

import java.util.PriorityQueue;
import java.util.Queue;

public class midNum {
    public int getUpMedian (int[] arr1, int[] arr2) {
        // write code here
        int len1=arr1.length,len2=arr2.length;
        Queue<Integer> queue=new PriorityQueue<>();
        for(int a:arr1){
            queue.offer(a);
        }
        for(int b:arr2){
            queue.offer(b);
        }
        System.out.println(queue.size());
        int res=0;
        int mid=(len1+len2)%2==0?(len1+len2)/2-1:(len1+len2);
        for(int i=0;i<=mid ;i++     ){
            res=queue.poll();
            System.out.println("队列中的数"+res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1= {1,2,3},arr2={3,4,5};
        midNum midNum = new midNum();
        int upMedian = midNum.getUpMedian(arr1, arr2);
        System.out.println(upMedian);
    }
}
