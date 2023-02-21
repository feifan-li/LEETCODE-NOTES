package Backtrack.LC980UniquePathsIII;

public class Solution980 {
    public static int ans = 0;
    public static int[] start;
    public static int allAvailableGrids = 0;
    public static int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==1) start = new int[]{i,j};
                else if(grid[i][j]!=-1) allAvailableGrids++;
            }
        }
        backtrack(start[0],start[1],0,grid);
        return ans;
    }
    private static void backtrack(int i, int j, int curSteps,int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==-1) return;
        if(grid[i][j]==2){
            if(curSteps == allAvailableGrids) ans++;
        }else{
            int temp = grid[i][j];
            grid[i][j] = -1;//avoid cycles
            backtrack(i,j+1,curSteps+1,grid);
            backtrack(i,j-1,curSteps+1,grid);
            backtrack(i+1,j,curSteps+1,grid);
            backtrack(i-1,j,curSteps+1,grid);
            grid[i][j] = temp;
        }
    }

    public static void main(String[] args) {
//        System.out.println(uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));//2
        System.out.println(uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}}));//4
//        System.out.println(uniquePathsIII(new int[][]{{0, 1}, {2, 0}}));//0
    }
}
