package LC899OrderlyQueue;

import java.util.Arrays;

public class Solution899 {
    public String orderlyQueue(String s, int k) {
        if(k>1){
            // 证明 :
            // 如果k == 2
            // 所以总可以做到有序
            // k > 2就更能做到了，所以k > 1直接排序返回
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            return String.valueOf(ca);
        }else{
            //simulation
            StringBuilder sb = new StringBuilder(s);
            String min = s;
            for(int i=0;i<s.length();++i){
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                if(sb.toString().compareTo(min)<0){
                    min = sb.toString();
                }
            }
            return min;
        }
    }
}
