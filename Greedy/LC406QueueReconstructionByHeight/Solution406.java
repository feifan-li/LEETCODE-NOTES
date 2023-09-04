package Greedy.LC406QueueReconstructionByHeight;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a, b)->(a[0]==b[0]?a[1]-b[1]:b[0]-a[0]));
        LinkedList<int[]> q = new LinkedList<>();
        for(int[] p:people) q.add(p[1],p);
        return q.toArray(new int[people.length][2]);
    }
}
