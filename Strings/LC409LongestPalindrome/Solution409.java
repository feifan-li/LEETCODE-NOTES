package Strings.LC409LongestPalindrome;

public class Solution409 {
    public int longestPalindrome(String s) {
        //一个回文串包含几种偶数频次的字符
        //或几种偶数频次的字符+一种只出现了一次的字符
        //或一种只出现了一次的字符
        if(s.length()==1)   return 1;
        int[] cnt = new int[58];
        for(int i=0;i<s.length();++i){
            cnt[s.charAt(i)-'A']++;
        }
        int ans = 0, center = 0;
        for(int i=0;i<58;++i){
            if(cnt[i]>=2){
                ans += 2*(cnt[i]/2);
            }
            if((cnt[i]&1)==1){
                center=1;
            }
        }
        return ans+center;
    }
}
