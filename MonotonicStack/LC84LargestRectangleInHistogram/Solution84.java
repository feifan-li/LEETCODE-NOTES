package MonotonicStack.LC84LargestRectangleInHistogram;

import java.util.Stack;

public class Solution84 {
    public int largestRectangleArea(int[] h) {
        if(h.length==1) return h[0];
        int max = 0, top = -1;
        int[] s = new int[h.length];//mono-stack
        for(int i=0;i<h.length;++i){
            while(top>=0 && h[i]<=h[s[top]]){
                int j = s[top--];
                int leftBound = top==-1?-1:s[top];
                int cur = h[j]*(i-leftBound-1);
                max = Math.max(max,cur);
            }
            s[++top] = i;
        }
        while(top>=0){
            int j=s[top--];
            int leftBound = top==-1?-1:s[top];
            int cur = h[j]*(h.length-leftBound-1);
            max = Math.max(max,cur);
        }
        return max;
    }
}
