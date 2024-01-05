package Backtrack.LC1066CampusBikesII;

public class Solution1066 {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length, m = bikes.length;
        int[][] d = new int[n][m];
        boolean[] visited = new boolean[m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                d[i][j] = Math.abs(workers[i][0]-bikes[j][0])+
                        Math.abs(workers[i][1]-bikes[j][1]);
            }
        }
        return backtrack(0,n-1,d,visited);
    }
    public int backtrack(int startWorker, int endWorker, int[][] d, boolean[] visited){
        if(startWorker>endWorker){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int j=0;j<visited.length;++j){
            if(!visited[j]){
                visited[j] = true;
                min = Math.min(min,d[startWorker][j]+backtrack(startWorker+1,endWorker,d,visited));
                visited[j] = false;
            }
        }
        return min;
    }
}
