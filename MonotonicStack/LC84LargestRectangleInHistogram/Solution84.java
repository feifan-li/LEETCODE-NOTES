package MonotonicStack.LC84LargestRectangleInHistogram;

import java.util.Stack;

public class Solution84 {
    public int largestRectangleArea(int[] h) {
        if(h.length==1) return h[0];
        int max = 0;
        Stack<Integer> s = new Stack<Integer>();//mono-stack
        for(int i=0;i<h.length;++i){
            while(!s.isEmpty() && h[i]<=h[s.peek()]){
                int j = s.pop();
                int leftBound = s.isEmpty()?-1:s.peek();
                int cur = h[j]*(i-leftBound-1);
                max = Math.max(max,cur);
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int j=s.pop();
            int leftBound = s.isEmpty()?-1:s.peek();
            int cur = h[j]*(h.length-leftBound-1);
            max = Math.max(max,cur);
        }
        return max;
    }
}
