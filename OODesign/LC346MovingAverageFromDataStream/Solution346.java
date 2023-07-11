package OODesign.LC346MovingAverageFromDataStream;

import java.util.LinkedList;

public class Solution346 {
    class MovingAverage {
        LinkedList<Integer> q;
        double sum;
        int size;
        public MovingAverage(int size) {
            q = new LinkedList<>();
            this.size = size;
            sum = 0.0;
        }

        public double next(int val) {
            q.add(val);
            sum += val;
            if(q.size()<=size)  return sum/q.size();
            sum -= q.removeFirst();
            return sum/q.size();
        }
    }
}
