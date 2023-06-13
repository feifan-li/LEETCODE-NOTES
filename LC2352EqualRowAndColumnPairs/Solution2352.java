package LC2352EqualRowAndColumnPairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution2352 {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String,Integer> rowFreq = new HashMap<>();
        HashSet<Integer> rowInitial = new HashSet<>();
        for(int i=0;i<n;++i){
            rowInitial.add(grid[i][0]);
            String rowString = Arrays.toString(grid[i]);
            rowFreq.put(rowString,rowFreq.getOrDefault(rowString,0)+1);
        }
        int ans = 0;
        for(int col = 0;col<n;++col){
            if(!rowInitial.contains(grid[0][col]))  continue;
            int[] sb = new int[n];
            for(int row=0;row<n;++row)  sb[row] = grid[row][col];
            String colString = Arrays.toString(sb);
            if(rowFreq.containsKey(colString))  ans += rowFreq.get(colString);
        }
        return ans;
    }
}
