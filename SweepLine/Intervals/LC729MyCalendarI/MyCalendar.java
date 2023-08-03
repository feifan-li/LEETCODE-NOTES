package SweepLine.Intervals.LC729MyCalendarI;

import java.util.TreeSet;

public class MyCalendar {
    TreeSet<int[]> events;
    public MyCalendar() {
        events = new TreeSet<>((a,b)->(a[0]-b[0]));
    }
    public boolean book(int start, int end) {
        int[] new_event = new int[]{start,end};
        int[] low = events.floor(new_event);
        int[] high = events.ceiling(new_event);
        if((low!=null && low[0]==start) || (high!=null && high[0]==start)) return false;
        else if((low!=null && low[1]>start) || (high!=null && high[0]<end)) return false;
        events.add(new_event);
        return true;
    }
}
