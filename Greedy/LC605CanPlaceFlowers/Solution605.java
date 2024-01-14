package Greedy.LC605CanPlaceFlowers;

public class Solution605 {
    public static boolean canPlaceFlowers(int[] f, int n) {
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
    public static boolean groundTruth(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            // Check if the current plot is empty.
            if (flowerbed[i] == 0) {
                // Check if the left and right plots are empty.
                boolean emptyLeftPlot = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRightPlot = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

                // If both plots are empty, we can plant a flower here.
                if (emptyLeftPlot && emptyRightPlot) {
                    flowerbed[i] = 1;
                    count++;
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }
        return count >= n;
    }
    public static void main(String[] args) {
        int testTimes = 1000000;
        int maxLen = 2000000;
        System.out.println("TEST BEGIN.");
        for(int i=1;i<=testTimes;++i){
            int len = (int)Math.random()*maxLen+1;
            int[] f = new int[len];
            int maxN = 0;
            for(int j=0;j<len;++j){
                f[j] = Math.random()>0.5?1:0;
                if(f[j]==0) maxN++;
            }
            int n = ((int)(Math.random()*maxN))/2;
            boolean myAns = canPlaceFlowers(f,n);
            boolean correctAns = groundTruth(f,n);
            if(myAns!=correctAns) {
                System.out.println("TEST FAILED!!! BAD!!!");
                break;
            }
        }
        System.out.println("TEST FINISH.");
    }
}
