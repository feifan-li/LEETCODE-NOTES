package OODesign.LC895MaxFreqStack;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution895 {
    static class FreqStack {
        private int maxFreq;
        private HashMap<Integer,Integer> valToFreq;
        private HashMap<Integer, ArrayList<Integer>> freqToValList;

        public FreqStack() {
            maxFreq = 0;
            valToFreq = new HashMap<>();
            freqToValList = new HashMap<>();
        }

        public void push(int val) {
            valToFreq.put(val,valToFreq.getOrDefault(val,0)+1);
            int curFreq = valToFreq.get(val);
            if(!freqToValList.containsKey(curFreq)) freqToValList.put(curFreq,new ArrayList<>());
            ArrayList<Integer> values = freqToValList.get(curFreq);
            values.add(val);
            maxFreq = Math.max(maxFreq,curFreq);
        }

        public int pop() {
            ArrayList<Integer> values = freqToValList.get(maxFreq);
            int last = values.size()-1;
            int ans = values.remove(last);
            if(values.size()==0) freqToValList.remove(maxFreq--);

            int freqBefore = valToFreq.get(ans);
            if(freqBefore == 1) valToFreq.remove(ans);
            else valToFreq.put(ans,freqBefore-1);

            return ans;
        }
    }

    public static void main(String[] args) {
        FreqStack obj = new FreqStack();
        obj.push(5);
        obj.push(7);
        obj.push(5);
        obj.push(7);
        obj.push(4);
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());

    }
}
