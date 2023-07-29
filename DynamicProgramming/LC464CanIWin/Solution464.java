package DynamicProgramming.LC464CanIWin;

public class Solution464 {
    public int[] memo = new int[1<<20];
    public boolean canIWin(int max, int total) {
        int sum = max*(max+1)/2;
        if(max>=total)  return true;
        else if(sum<total)  return false;
        else if(sum==total) return max%2==1;
        return dp(max,total,0);
    }
    public boolean dp(int max,int total,int visited){
        if(memo[visited]!=0)    return memo[visited]>0;
        if(total<=0)    return false;
        for(int i=0;i<max;++i){
            if((visited&(1<<i))==0 && !dp(max,total-(i+1),visited|(1<<i))){
                memo[visited] = 1;
                return true;
            }
        }
        memo[visited] = -1;
        return false;
    }
}
