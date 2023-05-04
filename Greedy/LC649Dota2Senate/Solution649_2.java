package Greedy.LC649Dota2Senate;

import java.util.LinkedList;
import java.util.Queue;

public class Solution649_2 {
    public static String predictPartyVictory(String s) {
        //Greedy:current senate ban his next senate who belongs to another party
        Queue<Integer> d = new LinkedList<>();
        Queue<Integer> r = new LinkedList<>();
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='D') d.add(i);
            else if(s.charAt(i)=='R') r.add(i);
        }
        while(d.size()>0 && r.size()>0){
            int di = d.poll();
            int ri = r.poll();
            if(di<ri)   d.add(di+s.length());
            else if(ri<di)  r.add(ri+s.length());
        }
        return d.size()>0?"Dire":"Radiant";
    }

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RRDDD"));
    }
}
