package LC495TeemoAttacking;

public class Solution495 {
    public int findPoisonedDuration(int[] t, int duration) {
        int total = duration;
        for(int i=t.length-1;i>=1;--i){
            if(t[i]-t[i-1]<duration){total += t[i]-t[i-1];}
            else{total += duration;}
        }
        return total;
    }
}
