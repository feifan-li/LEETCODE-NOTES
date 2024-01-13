package LC1347MinimumNumberOfStepsToMakeTwoStringsAnagram;

public class Solution1347 {
    public int minSteps(String s, String t) {
        assert s.length()==t.length();
        int[] cnt = new int[26];
        int ans = 0;
        for(int i=0;i<s.length();++i)   cnt[s.charAt(i)-'a']++;
        for(int i=0;i<t.length();++i)   cnt[t.charAt(i)-'a']--;
        for(int i=0;i<26;++i)   ans += Math.max(0,cnt[i]);
        return ans;
    }
}
