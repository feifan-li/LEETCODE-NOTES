package LC357CountNumbersWithUniqueDigits;

public class Solution357 {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)    return 1;
        int res = 10, cur = 9, remainDigits = 9;
        while(n-- > 1){
            cur *= remainDigits;
            res += cur;
            remainDigits--;
        }
        return res;
    }
}
