package Graph.Dijkstras.LC499TheMazeIII;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution499 {
    public class Node{
        int x,y,d;
        String path;
        Node(int x,int y,int d,String path){
            this.x = x;
            this.y = y;
            this.d = d;
            this.path = path;
        }
    }
    public int[][] dirs = new int[][]{{1,0},{0,-1},{0,1},{-1,0}};
    public String[] dirMap = new String[]{"d","l","r","u"};
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length, n = maze[0].length;
        int[][] dist = new int[m][n];
        for(int[] distRow:dist) Arrays.fill(distRow,999999);
        dist[ball[0]][ball[1]] = 0;
        String[][] paths = new String[m][n];
        for(String[] pathsRow:paths)   Arrays.fill(pathsRow,"z");
        paths[ball[0]][ball[1]] = "";
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->(a.d==b.d?a.path.compareTo(b.path):a.d-b.d));
        pq.add(new Node(ball[0],ball[1],0,""));
        while(!pq.isEmpty()){
            Node u = pq.poll();
            if(dist[u.x][u.y]<u.d || paths[u.x][u.y].compareTo(u.path)<0)   continue;//poll expired key directly
            if(u.x==hole[0] && u.y==hole[1])    return u.path;
            for(int i=0;i<4;++i){
                int vx = u.x,vy = u.y,dx = dirs[i][0],dy = dirs[i][1],cnt = 0;
                while(vx+dx>=0 && vy+dy>=0 && vx+dx<m
                        && vy+dy<n && maze[vx+dx][vy+dy]==0){
                    vx += dx;
                    vy += dy;
                    cnt++;
                    if(vx==hole[0] && vy==hole[1])  break;
                }
                if(u.x==vx && u.y==vy)    continue;
                if(dist[u.x][u.y]+cnt==dist[vx][vy]
                        && paths[vx][vy].compareTo(u.path+dirMap[i])>0){
                    paths[vx][vy] = u.path+dirMap[i];
                    pq.offer(new Node(vx,vy,dist[vx][vy],paths[vx][vy]));
                }else if(dist[u.x][u.y]+cnt<dist[vx][vy]){
                    dist[vx][vy] = dist[u.x][u.y]+cnt;
                    pq.offer(new Node(vx,vy,dist[vx][vy],u.path+dirMap[i]));
                }
            }
        }
        return "impossible";
    }
}
