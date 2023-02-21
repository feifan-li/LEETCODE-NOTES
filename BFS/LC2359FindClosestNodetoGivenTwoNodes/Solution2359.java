package BFS.LC2359FindClosestNodetoGivenTwoNodes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2359 {
    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        Arrays.fill(dist1,Integer.MAX_VALUE);
        boolean[] visited1 = new boolean[n];
        Queue<int[]> q1 = new LinkedList<int[]>();
        visited1[node1]=true;
        q1.offer(new int[]{node1,0});
        while(!q1.isEmpty()){
            int[] p = q1.poll();
            int curNode = p[0];
            int curDist = p[1];
            dist1[curNode] = curDist;
            int next = edges[curNode];
            if(next!=-1 && !visited1[next]){
                visited1[next]=true;
                q1.offer(new int[]{next,curDist+1});
            }
        }
        //System.out.println(Arrays.toString(dist1));
        int[] dist2 = new int[n];
        Arrays.fill(dist2,Integer.MAX_VALUE);
        boolean[] visited2 = new boolean[n];
        Queue<int[]> q2 = new LinkedList<int[]>();
        visited2[node2]=true;
        q2.offer(new int[]{node2,0});
        while(!q2.isEmpty()){
            int[] p = q2.poll();
            int curNode = p[0];
            int curDist = p[1];
            dist2[curNode] = curDist;
            int next = edges[curNode];
            if(next!=-1 && !visited2[next]){
                visited2[next]=true;
                q2.offer(new int[]{next,curDist+1});
            }
        }
        //System.out.println(Arrays.toString(dist2));
        int ans = -1;//is a node
        int max = Integer.MAX_VALUE;
        for(int i=0;i<n;++i){
            if(Math.max(dist1[i],dist2[i])<max){
                max = Math.max(dist1[i],dist2[i]);
                ans = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(closestMeetingNode(new int[]{2,2,3,-1},0,1));
        System.out.println(closestMeetingNode(new int[]{1,2,-1},0,2));
    }
}
