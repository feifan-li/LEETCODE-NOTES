package LC386LexicographicalNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int num = 1;
        for(int cnt = 0; cnt < n;++cnt){
            list.add(num);
            //总位数小于n的位数时，每次补零
            if(num*10<=n)   num *= 10;
                //总位数等于n的位数时，每次个位加一，注意不能使十位增加
            else if(num%10<9 && num<=n-1)   num += 1;
                //个位逢九进一时，或当前数已经是最大数，去掉个位后加一，若该结果有后缀零则去掉后缀零
                //e.g. 109->11, 129->13, 199->2
            else{
                num = num/10 + 1;
                while(num%10==0)   num /= 10;
            }
        }
        return list;
    }
}
