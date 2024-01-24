package LC1239MaxLengthOfAConcatenatedStringWithUniqueCharacters;

import java.util.List;
public class Solution1239 {
    public int maxLength(List<String> arr) {
        int m = arr.size(), max = 0, pow = 0;
        for(int i=0;i<m;++i){
            pow |= (1<<i);
        }
        for(int i=1;i<=pow;++i){
            int cnt = 0,len = 0;
            for(int j=0;j<m;++j){
                if(((1<<j)&i)>0){
                    for(char c:arr.get(m-1-j).toCharArray()){
                        if((cnt&(1<<(c-'a')))>0){
                            len = -1;
                            break;
                        }
                        cnt |= 1<<(c-'a');
                    }
                    if(len == -1){
                        break;
                    }
                    len += arr.get(m-1-j).length();
                }
            }
            max = Math.max(max, len);
        }
        return max;
    }
}
