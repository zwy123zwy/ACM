package org.example.threeSUM;

import java.util.*;
class Solution{
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                return res;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;

            while(right>left){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum>0){
                    right--;
                }else if(sum<0){
                    left++;
                }else{
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    if(right>left&&nums[right]==nums[right-1])right--;
                    if(right>left&&nums[left]==nums[left+1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}
public class Main{
    public static void main(String args[]){
        Solution solution =new Solution();
        int [] nums={-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res=solution.threeSum(nums);
        System.out.println(res);
    }
}