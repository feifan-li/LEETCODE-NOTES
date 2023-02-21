package SweepLine.LC759EmployeeFreeTime;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution759 {
    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b)->a.start-b.start);
        for(List<Interval> list:schedule){
            for(Interval intv:list){
                pq.add(intv);
            }
        }
        Interval cur = pq.poll();
        while(!pq.isEmpty()){
            if(cur.end>=pq.peek().start) cur.end = Math.max(cur.end,pq.poll().end);//overlap,poll() and merge
            else{//no overlap, find a free time slot
                res.add(new Interval(cur.end,pq.peek().start));
                cur = pq.poll();
            }
        }
        return res;
    }
}
