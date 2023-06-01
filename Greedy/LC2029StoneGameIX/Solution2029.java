package Greedy.LC2029StoneGameIX;

public class Solution2029 {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];
        for(int stone:stones)   cnt[stone%3]++;
        // if(cnt[1]+cnt[2]==0)    return false;
        if(cnt[0]%2==0){
            if(cnt[1]==0 || cnt[2]==0)  return false;
            return true;
        }
        if(cnt[0]%2==1){
            if(Math.abs(cnt[1]-cnt[2])>2)   return true;
            return false;
        }
        return false;
    }
}
