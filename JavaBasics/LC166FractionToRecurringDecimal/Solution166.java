package JavaBasics.LC166FractionToRecurringDecimal;

import java.util.HashMap;

public class Solution166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        StringBuilder ans = new StringBuilder();
        if((numerator<0)^(denominator<0))   ans.append('-');
        long a = numerator;
        long b = denominator;
        a = Math.abs(a);
        b = Math.abs(b);
        ans.append(a/b);
        long remain = a%b;
        if(remain==0)   return ans.toString();
        else ans.append('.');
        HashMap<Long,Integer> map = new HashMap<>();
        while(remain!=0){
            if(map.containsKey(remain)){
                ans.insert(map.get(remain),"(");
                ans.append(")");
                break;
            }
            map.put(remain,ans.length());
            remain = remain*10;
            ans.append(remain/b);
            remain %= b;
        }

        return ans.toString();
    }
}
