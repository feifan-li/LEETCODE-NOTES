package Greedy.LC159LongestSubstringWithAtMostTwoDistinctChars;

public class Solution159_2 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if(n==1 || n==2) return n;
        int[] map = new int[58];//A,B,...,Z,...,a,b,...,z
        int set = 1;
        map[s.charAt(0)-'A'] = 1;
        int max = Integer.MIN_VALUE;
        int right = 0;
        for(int i=0;i<n;++i){
            while(right<n && set<=2){
                right++;
                if(right<n){
                    if((++map[s.charAt(right)-'A']) == 1) set ++;
                }
            }
            max = Math.max(max,right-i);
            if(right==n-1)  return max;
            if((--map[s.charAt(i)-'A'])==0) set--;
        }
        return max;
    }
}
