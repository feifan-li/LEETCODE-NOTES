package Greedy;

public class Solution605 {
    public boolean canPlaceFlowers(int[] f, int n) {
        if(f.length==1) return f[0]==1?n<=0:n<=1;
        int dp=0;//max flowers can be planted
        if(f[0]==0 && f[1]==0){
            f[0] = 1;
            dp++;
        }
        int i=1;
        while(i<f.length-1){
            if(f[i]==0 && f[i-1]+f[i+1]==0) {
                f[i]=1;
                dp++;
            }
            i++;
        }
        if(f[i-1]==0 && f[i]==0) dp++;
        return n<=dp;
    }
}
