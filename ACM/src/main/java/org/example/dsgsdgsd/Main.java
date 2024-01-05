package org.example.dsgsdgsd;
import java.util.*;
class Solution{
    public int longestConsecutive(int [] nums){
        if(nums.length==0){return 0;}
        Arrays.sort(nums);
        int res=0;//最终结果
        int len=1;
        int currentNum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==currentNum+1){
                len=len+1;
                currentNum=nums[i];
                res=Math.max(res,len);
            }else if(nums[i]==currentNum){
                continue;
            }else {
                len=1;
                currentNum=nums[i];
            }
        }
        return res;
    }
}
public class Main{
    public static void main(String []args){
        int[] nums = {100,4,200,1,3,2};
        Solution solution =new Solution();
        int res=solution.longestConsecutive(nums);
        System.out.println(res);
    }
}
