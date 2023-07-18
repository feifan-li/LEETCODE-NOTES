package LC361BombEnemy;

public class Solution361 {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length, n = grid[0].length, max = 0;
        int[] killedInCol = new int[n];
        for(int i=0;i<m;++i){
            int killedInRow = 0;
            for(int j=0;j<n;++j){
                if(grid[i][j]=='0'){
                    int kill = 0;
                    if(j>0 && grid[i][j-1]=='0')    kill = killedInRow;
                    else{
                        for(int col = j-1;col>=0;--col){
                            if(grid[i][col]!='W') kill += (grid[i][col]=='E'?1:0);
                            else break;
                        }
                        for(int col = j+1;col<n;++col){
                            if(grid[i][col]!='W') kill += (grid[i][col]=='E'?1:0);
                            else break;
                        }
                        killedInRow = kill;
                    }
                    if(i>0 && grid[i-1][j]=='0')    kill += killedInCol[j];
                    else{
                        for(int row=i-1;row>=0;--row){
                            if(grid[row][j]!='W') kill += (grid[row][j]=='E'?1:0);
                            else   break;
                        }
                        for(int row=i+1;row<m;++row){
                            if(grid[row][j]!='W') kill += (grid[row][j]=='E'?1:0);
                            else   break;
                        }
                        killedInCol[j] = kill - killedInRow;
                    }
                    max = Math.max(max,kill);
                }
            }
        }
        return max;
    }
}
