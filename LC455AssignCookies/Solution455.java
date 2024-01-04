package LC455AssignCookies;

import java.util.Arrays;

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        /* output the maximum number of content children */
        int m = g.length, n = s.length, ans = 0;
        int i=0,j=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i<m && j<n){
            if(s[j]>=g[i]){
                ans++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return ans;
    }
}
