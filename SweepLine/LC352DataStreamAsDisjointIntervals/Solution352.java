package SweepLine.LC352DataStreamAsDisjointIntervals;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution352 {
    class SummaryRanges {
        public TreeSet<int[]> set;
        public SummaryRanges() {
            set = new TreeSet<>((a,b)->a[0]==b[0]? a[1]-b[1] : a[0]-b[0]);
        }

        public void addNum(int value) {
            int[] interval = new int[]{value,value};
            if(set.contains(interval)) return;
            int[] low = set.lower(interval);
            int[] high = set.higher(interval);
            //if is covered:
            if((high!=null && high[0] == value) || (low!=null && low[1]>=value)) return;
            //if connect two slot
            if(low!=null && low[1]+1==value && high!=null && value+1==high[0]){
                low[1] = high[1];
                set.remove(high);
            }else if(low!=null && low[1]+1==value){
                low[1] = value;
            }else if(high!=null && value+1==high[0]){
                high[0] = value;
            }else{
                set.add(interval);
            }
        }

        public int[][] getIntervals() {
            List<int[]> res = new ArrayList<>();
            for(int[] i:set) res.add(i);
            return res.toArray(new int[res.size()][]);
        }
    }

    public static void main(String[] args) {
        /**
         * Your SummaryRanges object will be instantiated and called as such:
         * SummaryRanges obj = new SummaryRanges();
         * obj.addNum(value);
         * int[][] param_2 = obj.getIntervals();
         */
    }
}
