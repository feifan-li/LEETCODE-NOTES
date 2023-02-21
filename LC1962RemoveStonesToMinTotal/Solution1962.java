package LC1962RemoveStonesToMinTotal;

import java.util.PriorityQueue;

public class Solution1962 {
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)->b-a);
        int ans = 0;
        for(int i:piles){
            ans += i;
            heap.add(i);
        }
        for(int i=1;i<=k;++i){
            int pile = heap.poll();
            ans -= pile/2;
            pile -= pile/2;
            heap.add(pile);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minStoneSum(new int[]{5,4,9},2));
        System.out.println(minStoneSum(new int[]{4,3,6,7},3));
    }
}
