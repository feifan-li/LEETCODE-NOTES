package LC1291SequentialDigits;

import java.util.ArrayList;
import java.util.List;

public class Solution1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for(int cnt = getNumberOfDigits(low);cnt<=Math.min(9,getNumberOfDigits(high));++cnt){
            int base = getBase(cnt);
            int delta = getDelta(cnt);
            for(int j=cnt;j<=9;++j){
                if(base>high){
                    break;
                }else if(base >= low && base <= high){
                    ans.add(base);
                }
                base += delta;
            }
        }
        return ans;
    }
    public int getNumberOfDigits(int n){
        int cnt = 0;
        while(n>0){
            n = n/10;
            cnt ++;
        }
        return cnt;
    }
    public int getDelta(int cnt){
        int delta = 0;
        for(int i=cnt;i>0;i--){
            delta = delta*10+1;
        }
        return delta;
    }
    public int getBase(int cnt){
        int base = 0;
        for(int i=1;i<=cnt;++i){
            base = base*10 + i;
        }
        return base;
    }
}
