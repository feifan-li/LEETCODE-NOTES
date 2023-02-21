package BFS.LC841KeysAndRooms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution841 {
    //BFS
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;++i){
                int key = q.poll();
                for(int room:rooms.get(key)){
                    if(!visited[room]){
                        q.offer(room);
                        visited[room] = true;
                    }
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;++i){
            if(visited[i]) ++ans;
        }
        return ans == n;
    }

    public static void main(String[] args) {
        List<List<Integer>> test1 = new LinkedList<>();

        test1.add(new LinkedList<Integer>(Arrays.asList(1)));
        test1.add(new LinkedList<Integer>(Arrays.asList(2)));
        test1.add(new LinkedList<Integer>(Arrays.asList(3)));
        test1.add(new LinkedList<Integer>());

        List<List<Integer>> test2 = new LinkedList<>();

        test2.add(new LinkedList<Integer>(Arrays.asList(1,3)));
        test2.add(new LinkedList<Integer>(Arrays.asList(3,0,1)));
        test2.add(new LinkedList<Integer>(Arrays.asList(2)));
        test2.add(new LinkedList<Integer>(Arrays.asList(0)));

        List<List<Integer>> test3 = new LinkedList<>();

        test3.add(new LinkedList<Integer>(Arrays.asList(1)));
        test3.add(new LinkedList<Integer>());
        test3.add(new LinkedList<Integer>(Arrays.asList(0,3)));
        test3.add(new LinkedList<Integer>(Arrays.asList(1)));

        System.out.println(canVisitAllRooms(test1));//true
        System.out.println(canVisitAllRooms(test2));//false
        System.out.println(canVisitAllRooms(test3));//false
    }
}
