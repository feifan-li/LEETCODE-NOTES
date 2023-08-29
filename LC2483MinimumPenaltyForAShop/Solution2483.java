package LC2483MinimumPenaltyForAShop;

public class Solution2483 {
    public int bestClosingTime(String customers) {
        char[] s = customers.toCharArray();
        //initially, close at hour 0
        int n = customers.length(), closeAt = 0, curPenalty = 0;
        for(int i=0;i<n;++i){
            if(s[i]!='N')   curPenalty++;
        }
        int min = curPenalty;
        for(int i=1;i<=n;++i){
            //closing at hour i => change mask[i-1] to 'Y' so that 'N' first appear at mask[i]
            if(s[i-1]=='Y'){
                //the penalty will decrease
                curPenalty--;
                if(curPenalty<min){
                    closeAt = i;
                    min = curPenalty;
                }
            }else{
                //the penalty will increase
                curPenalty++;
            }
        }
        return closeAt;
    }
}
