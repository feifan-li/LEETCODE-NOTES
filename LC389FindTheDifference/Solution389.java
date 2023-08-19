package LC389FindTheDifference;

public class Solution389 {
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for(char c:s.toCharArray()) cnt[c-'a']++;
        for(char c:t.toCharArray()){
            cnt[c-'a']--;
            if(cnt[c-'a']==-1)  return c;
        }
        return '#';
    }
}
