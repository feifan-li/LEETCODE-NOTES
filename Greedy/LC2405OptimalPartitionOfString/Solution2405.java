package Greedy.LC2405OptimalPartitionOfString;

import java.util.Arrays;

public class Solution2405 {
    public int partitionString(String s) {
        //Greedy
        int[] lastSeen = new int[26];//for each char, record the index it last appears at
        int ans = 1,subStart = 0;
        Arrays.fill(lastSeen,-1);
        for(int i=0;i<s.length();++i){
            if(lastSeen[s.charAt(i)-'a']>=subStart){
                ans++;
                subStart = i;
            }
            lastSeen[s.charAt(i)-'a']=i;
        }
        return ans;
    }
}
