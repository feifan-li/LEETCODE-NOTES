package LC767ReorganizeString;

import java.util.ArrayList;
import java.util.Collections;

public class Solution767 {
    public String reorganizeString(String s) {
        int n = s.length(), max = 0, i = 0, j = 0;
        int[] cnt = new int[26];
        for(i=0;i<n;++i)    cnt[s.charAt(i)-'a']++;
        for(i=0;i<26;++i)   max = Math.max(max,cnt[i]);
        ArrayList<int[]> arr = new ArrayList<>();
        for(i=0;i<n;++i){
            arr.add(new int[]{s.charAt(i)-'a',cnt[s.charAt(i)-'a']});
        }
        Collections.sort(arr,(a, b)->(a[1]==b[1]?a[0]-b[0]:b[1]-a[1]));
        StringBuilder ans = new StringBuilder();
        StringBuilder[] subs = new StringBuilder[max];
        for(i=0;i<max;++i)  subs[i] = new StringBuilder();
        while(j<n){
            subs[(i++)%max].append((char)(arr.get(j++)[0]+'a'));
        }
        for(i=0;i<max;++i)    ans.append(subs[i]);
        return check(ans);
    }
    public String check(StringBuilder sb){
        String s = sb.toString();
        for(int i=0;i<s.length()-1;++i){
            if(s.charAt(i)==s.charAt(i+1))  return "";
        }
        return s;
    }
}
