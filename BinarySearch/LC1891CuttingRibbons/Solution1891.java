package BinarySearch.LC1891CuttingRibbons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1891 {
    public int maxLength(int[] ribbons, int k) {
        Arrays.sort(ribbons);
        int lenL = 1, lenR = ribbons[ribbons.length-1], maxLen = 0;
        while(lenL<=lenR){
            int lenMid = lenL+(lenR-lenL)/2;
            if(canGetKRibbonsOf(ribbons,k,lenMid)){
                maxLen = Math.max(maxLen,lenMid);
                lenL = lenMid+1;
            }else{
                lenR = lenMid-1;
            }
        }
        return maxLen;
    }
    public boolean canGetKRibbonsOf(int[] ribbons, int k,int len){
        int cnt = 0;
        for(int i=ribbons.length-1;i>=0;--i){
            cnt += ribbons[i]/len;
            if(cnt>=k)  return true;
        }
        return cnt>=k;
    }
}
