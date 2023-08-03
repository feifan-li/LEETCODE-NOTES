package SweepLine.LC2251NumberOfFlowersInFullBloom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Solution2251 {
    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = people.length, count = 0;
        int[] ans = new int[n];
        ArrayList<int[]> list = new ArrayList<>(flowers.length*2);
        for(int[] flower:flowers){
            list.add(new int[]{flower[0],1});
            list.add(new int[]{flower[1]+1,-1});
        }
        Collections.sort(list,(a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        TreeMap<Integer,Integer> timeToFlowers = new TreeMap<>();
        for(int[] point:list){
            count += point[1];
            timeToFlowers.put(point[0],count);
        }
        for(int i=0;i<n;++i){
            if(people[i]<list.get(0)[0] || people[i]>list.get(list.size()-1)[0])    ans[i] = 0;
            else    ans[i] = timeToFlowers.get(timeToFlowers.floorKey(people[i]));
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
