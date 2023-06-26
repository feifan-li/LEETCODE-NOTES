package Greedy.LC296BestMeetingPoint;

import java.util.ArrayList;

public class Solution296 {
    public int minTotalDistance(int[][] grid) {
        //  min(sigma(i=0,n){|Px-Fix|} + sigma(i=0,n){|Py-Fiy|})
        //= min(sigma(i=0,n){|Px-Fix|}) + min(sigma(i=0,n){|Py-Fiy|})
        ArrayList<Integer> xlist = new ArrayList<>();
        ArrayList<Integer> ylist = new ArrayList<>();
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]==1){
                    xlist.add(i);
                }
            }
        }
        for(int j=0;j<grid[0].length;++j){
            for(int i=0;i<grid.length;++i){
                if(grid[i][j]==1){
                    ylist.add(j);
                }
            }
        }
        return min(xlist)+min(ylist);
    }
    private int min(ArrayList<Integer> list){
        //Greedy:
        int left = 0, right = list.size()-1;
        int sum = 0;
        while(left<right)   sum += list.get(right--)-list.get(left++);
        return sum;
    }
}
