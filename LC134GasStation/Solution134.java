package LC134GasStation;

public class Solution134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] diff = new int[2*n];
        int gasSum=0,costSum=0;
        for(int i=0;i<n;++i){
            diff[i] = gas[i]-cost[i];
            diff[i+n] = gas[i]-cost[i];
            gasSum+=gas[i];
            costSum+=cost[i];
        }
        if(gasSum<costSum) return -1;
        int start =0, cur=0;
        for(int i=0;i<2*n;++i){
            if(cur<0){
                cur=diff[i];
                start=i;
            }else{
                cur+=diff[i];
            }
        }
        return start;
    }
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
        System.out.println(canCompleteCircuit(new int[]{2,3,4},new int[]{3,4,3}));
    }
}
