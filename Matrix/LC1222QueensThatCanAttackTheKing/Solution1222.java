package Matrix.LC1222QueensThatCanAttackTheKing;

import java.util.ArrayList;
import java.util.List;

public class Solution1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] mat = new int[8][8];
        mat[king[0]][king[1]] = 2;
        for(int[] q:queens) mat[q[0]][q[1]] = 1;
        List<List<Integer>> ans = new ArrayList<>();
        for(int[] q:queens){
            if(q[0]==king[0] || q[1]==king[1] ||
                    Math.abs(q[0]-king[0])==Math.abs(q[1]-king[1])){
                int x = king[0]==q[0]?0:(king[0]-q[0])/Math.abs(king[0]-q[0]);
                int y = king[1]==q[1]?0:(king[1]-q[1])/Math.abs(king[1]-q[1]);
                int i = q[0]+x, j = q[1]+y;
                while(i>=0 && j>=0 && i<8 && j<8 && mat[i][j]==0){
                    i += x;
                    j += y;
                }
                if(mat[i][j]==2)    ans.add(new ArrayList<>(List.of(q[0],q[1])));
            }
        }
        return ans;
    }
}
