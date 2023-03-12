package LC202HappyNumber;

import java.util.HashSet;

public class Solution202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int ssd = getSsd(n);
        while(set.add(ssd)){//does not contain ssd then add ssd
            if(ssd == 1) return true;
            ssd = getSsd(ssd);
        }
        return false;
    }
    private int getSsd(int n){
        int ans = 0;
        while(n>0){
            int digit = n%10;
            ans += digit*digit;
            n /= 10;
        }
        return ans;
    }
}
