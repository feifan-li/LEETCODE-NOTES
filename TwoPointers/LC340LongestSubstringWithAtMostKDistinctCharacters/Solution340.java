package TwoPointers.LC340LongestSubstringWithAtMostKDistinctCharacters;

public class Solution340 {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0)    return 0;
        int[] cnt = new int[256];
        int l = 0, distinct = 0, ans = 1;
        for(int r=0;r<s.length();++r){
            if(cnt[s.charAt(r)]++ == 0) distinct++;
            while(distinct>k){
                if(--cnt[s.charAt(l++)]==0) distinct--;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba",2));
    }
}
