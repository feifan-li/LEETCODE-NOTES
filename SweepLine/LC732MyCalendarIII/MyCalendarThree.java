package SweepLine.LC732MyCalendarIII;

import java.util.TreeMap;

public class MyCalendarThree {
    private TreeMap<Integer,Integer> list;
    public MyCalendarThree() {
        list = new TreeMap<>();
    }

    public int book(int s, int e) {
        list.put(s,list.getOrDefault(s,0)+1);
        list.put(e,list.getOrDefault(e,0)-1);
        int k = -1, count = 0;
        for(int delta:list.values()){
            count += delta;
            k = Math.max(k,count);
        }
        return k;
    }
}
