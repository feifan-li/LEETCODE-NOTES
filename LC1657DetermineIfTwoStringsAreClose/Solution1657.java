package LC1657DetermineIfTwoStringsAreClose;

import java.util.Arrays;

public class Solution1657 {
    public boolean closeStrings(String word1, String word2) {
        //word1 and word2 must have same length
        //word1 and word2 must contain same set of characters
        if(word1.length()!=word2.length()){
            return false;
        }
        int a = 0, b = 0;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for(int i=0;i<word1.length();++i){
            a |= 1<<(word1.charAt(i)-'a');
            cnt1[word1.charAt(i)-'a']++;
        }
        for(int i=0;i<word2.length();++i){
            b |= 1<<(word2.charAt(i)-'a');
            cnt2[word2.charAt(i)-'a']++;
        }
        if(a!=b){
            return false;
        }
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        for(int i=0;i<26;++i){
            if(cnt1[i]!=cnt2[i])   return false;
        }
        return true;
    }
}
