package OODesign.LC362DesignHitCounter;

import java.util.LinkedList;

public class HitCounter {
    public LinkedList<Integer> q;
    public HitCounter() {
        q = new LinkedList<>();
    }

    public void hit(int timestamp) {
        q.add(timestamp);//since all calls are chronological, q is sorted natrually
    }

    public int getHits(int timestamp) {
        while(q.size()>0 && timestamp-q.get(0)>=300)  q.removeFirst();
        return q.size();
    }
}
