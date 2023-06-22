package DynamicProgramming.LC276PaintFence;

public class Solution276 {
    public int numWays(int n, int k) {
        if(n==1)    return k;
        if(n==2)    return k*k;
        int[] total = new int[n+1];
        total[1] = k;
        total[2] = k*k;
        for(int i=3;i<=n;++i){
            total[i] += (k-1)*total[i-1];//choose a color different with post i-1
            total[i] += (k-1)*total[i-2]; //choose a color same with post i-1, then must be different with post i-2
        }
        return total[n];
    }
}
