package org.example.substring;

import java.util.*;
class Solution{
    public int lenghtOfLongestSubstring(String s){
        Set<Character> set=new HashSet<>();
        int left=0,right=0;
        int max=Integer.MIN_VALUE;
        while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
            max=Math.max(max,set.size());
        }
        return max;
    }
}
public class Main{
    public static void main(String args[]){
        Solution solution=new Solution();
        String s="pwwkew";
        int res=solution.lenghtOfLongestSubstring(s);
        System.out.println(res);
    }

}