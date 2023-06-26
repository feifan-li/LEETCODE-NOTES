package OODesign.LC295FindMedianFromDataStream;

import java.util.PriorityQueue;

public class Solution295 {
    class MedianFinder {
        public PriorityQueue<Integer> small;//大根堆， 小于中位数的部分
        public PriorityQueue<Integer> large;//小根堆， 大于等于中位数的部分
        public MedianFinder() {
            small = new PriorityQueue<>((a,b)->(b-a));
            large = new PriorityQueue<>();
        }

        public void addNum(int num) {
            large.add(num);
            small.add(large.poll());//若共添加了奇数个元素，此时small中多一个；若共添加了偶数个元素，此时两堆一样大
            if(large.size()<small.size())   large.add(small.poll());//若共添加了奇数个元素，此时large中多一个；若共添加了偶数个元素，此时两堆一样大
        }

        public double findMedian() {
            //两堆一样大，则取两堆顶；两堆不一样大，则一定是large堆多一个，故取large堆顶
            return large.size()>small.size()?large.peek()*1.0:(large.peek()*1.0+small.peek()*1.0)*0.5;
        }
    }
}
