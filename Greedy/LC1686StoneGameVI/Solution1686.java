package Greedy.LC1686StoneGameVI;

import java.util.Arrays;

public class Solution1686 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] sum = new int[n][2];
        for(int i=0;i<n;++i){
            sum[i][0] = i;
            sum[i][1] = aliceValues[i] + bobValues[i];
        }
        Arrays.sort(sum,(a, b)->(b[1]-a[1]));
        int a = 0;
        for(int i=0;i<n;++i){
            if(i%2==0)  a += aliceValues[sum[i][0]];
            else a -= bobValues[sum[i][0]];
        }
        return a!=0?(a>0?1:-1):0;
    }
}
