package SweepLine.LC218SkylineProblem;

import java.util.*;

public class Solution218 {
    //sweep line
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] points = new int[buildings.length*2][2];
        for(int i=0;i<buildings.length;++i){
            points[i*2][0] = buildings[i][0];
            points[i*2][1] = buildings[i][2];
            points[i*2+1][0] = buildings[i][1];
            points[i*2+1][1] = -buildings[i][2];
        }
        Arrays.sort(points,(a, b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        //a[0]==b[0]: new building appears before old building
        PriorityQueue<Integer> height = new PriorityQueue<>((a,b)->b-a);//max-heap
        height.offer(0);
        int preMax = 0;
        for(int[] p:points){
            if(p[1]>0) height.offer(p[1]);//add new building
            else height.remove(-p[1]);//remove building
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
