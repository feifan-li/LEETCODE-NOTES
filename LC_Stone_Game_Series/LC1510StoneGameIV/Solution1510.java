package LC_Stone_Game_Series.LC1510StoneGameIV;

public class Solution1510 {
    public int[] memo;
    public boolean winnerSquareGame(int n) {
        memo = new int[n+1];
        memo[0] = -1;
        return canWin(n);
    }
    private boolean canWin(int n){
        if(memo[n]!=0)   return memo[n]==1;
        for(int i=(int)(Math.sqrt(n));i>=1;--i){
            if(!canWin(n-i*i)){
                memo[n] = 1;
                return true;
            }
        }
        memo[n] = -1;
        return false;
    }
}
