package LC703KthLargestElementinaStream;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution703 {
    class KthLargest {
        public int k,n;
        public ArrayList<Integer> stream;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.stream = new ArrayList<>();
            for(int num:nums){
                stream.add(num);
            }
            this.n = stream.size();
            stream.sort((a,b)->(a-b));
        }

        public int add(int val) {
            int i = searchLeftMostGreaterThan(val);
            stream.add(i,val);
            n++;
            return stream.get(n-k);
        }
        private int searchLeftMostGreaterThan(int val){
            int left = 0, right = stream.size()-1;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(stream.get(mid)<=val){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
            return left;
        }
    }
}
