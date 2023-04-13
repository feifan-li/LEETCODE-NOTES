package LC2390RemovingStarsFromAString;

import java.util.Arrays;

public class Solution2390 {
    public String removeStars(String s) {
        //traverse s in reverse order
        boolean[] res = new boolean[s.length()];
        Arrays.fill(res,true);
        StringBuilder sb = new StringBuilder();
        int i = s.length()-1;
        int stars = 0;
        while(i>=0){
            if(s.charAt(i)=='*'){
                stars++;
                res[i] = false;
            }else if(stars>0){
                stars--;
                res[i] = false;
            }
            i--;
        }
        for(i=0;i<s.length();++i){
            if(res[i]) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
