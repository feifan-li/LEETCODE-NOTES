package LC392IsSubSequence;

public class Solution392 {
    public boolean isSubsequence(String ss, String ts) {
        char[] s = ss.toCharArray();
        char[] t = ts.toCharArray();
        int p1=0,p2=0;
        while(p1<s.length && p2<t.length){
            if(s[p1]==t[p2]){
                p1++;
                p2++;
            }else{
                p2++;
            }
        }
        if(p1==s.length) return true;
        return false;
    }
}
