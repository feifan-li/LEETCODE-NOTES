package Greedy.LC2141MaxRunningTimeOnNComputers;

import java.util.Arrays;

public class Solution2141 {
    public long maxRunTime(int n, int[] batteries) {
        int m = batteries.length;
        Arrays.sort(batteries);
        long[] buf = new long[n];
        long supl = 0L;
        for(int i=0;i<n;++i)    buf[i] = batteries[i+m-n];
        for(int i=0;i<m-n;++i)     supl += batteries[i];
        for(int i=0;i<n-1;++i){
            if((buf[i+1]-buf[i])*(long)(i+1)>supl)  return buf[i] + supl/(long)(i+1);
            supl -= (buf[i+1]-buf[i])*(long)(i+1);
        }
        return buf[n-1] + supl/n;
    }
}
