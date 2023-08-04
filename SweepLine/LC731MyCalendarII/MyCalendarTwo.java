package SweepLine.LC731MyCalendarII;

import java.util.TreeMap;

public class MyCalendarTwo {
    //sweep line
    TreeMap<Integer,Integer> timeToBookings;
    public MyCalendarTwo() {
        timeToBookings = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        timeToBookings.put(start,timeToBookings.getOrDefault(start,0)+1);
        timeToBookings.put(end,timeToBookings.getOrDefault(end,0)-1);
        int count = 0;
        for(int booking:timeToBookings.values()){
            count += booking;
            if(count>=3){
                timeToBookings.put(start,timeToBookings.get(start)-1);
                timeToBookings.put(end,timeToBookings.get(end)+1);
                return false;
            }
        }
        return true;
    }
}
