package Strings.LC387FirstUniqueCharacterInAString;

public class Solution387 {
    public int firstUniqChar(String s) {
        //第一个只出现了一次的字符的下标
        int[] cnt = new int[26];
        for(int i=0;i<s.length();++i)   cnt[s.charAt(i)-'a']++;
        for(int i=0;i<s.length();++i){
            if(cnt[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }
}
