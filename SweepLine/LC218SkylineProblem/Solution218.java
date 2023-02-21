package SweepLine.LC218SkylineProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution218 {
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> points = new ArrayList<>();
        for(int[] building:buildings){
            points.add(new int[]{building[0],-building[2]});
            points.add(new int[]{building[1],building[2]});
        }
        Collections.sort(points,(a, b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        //a[0]==b[0]: new building appears before old building
        PriorityQueue<Integer> height = new PriorityQueue<>((a, b)->b-a);//max-heap
        height.offer(0);
        int preMax = 0;
        for(int[] p:points){
            if(p[1]<0) height.offer(-p[1]);//add new building
            else height.remove(p[1]);//remove building
            int curMax = height.peek();
            if(preMax!=curMax){//最大高度发生变化时 发现了新的key point
                res.add(List.of(p[0],curMax));
                preMax = curMax;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //边界条件
        System.out.println(getSkyline(new int[][]{{0, 2, 3}, {2, 5, 3}}));
        System.out.println(getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}}));
    }
}
