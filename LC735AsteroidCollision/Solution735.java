package LC735AsteroidCollision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution735 {
    public int[] asteroidCollision(int[] a) {
        List<int[]> l = new ArrayList<>();
        LinkedList<int[]> r = new LinkedList<>();
        for(int i=0;i<a.length;++i){
            if(a[i]>0) r.add(new int[]{a[i],i});
            else{
                if(r.isEmpty()) l.add(new int[]{a[i],i});
                else{
                    while(r.size()!=0 && r.getLast()[0]<Math.abs(a[i]))   r.removeLast();
                    if(r.size()!=0 && r.getLast()[0]==Math.abs(a[i])){
                        r.removeLast();
                        continue;
                    }
                    if(r.size()==0) l.add(new int[]{a[i],i});
                }
            }
        }
        int[] res = new int[l.size()+r.size()];
        int i = 0, p = 0, q = 0;
        while(p<l.size() && q<r.size())  res[i++] = l.get(p)[1]<r.get(q)[1]?l.get(p++)[0]:r.get(q++)[0];
        while(p<l.size())    res[i++] = l.get(p++)[0];
        while(q<r.size())   res[i++] = r.get(q++)[0];
        return res;
    }
}
