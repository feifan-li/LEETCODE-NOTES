package LC885SpiralMatrixIII;

import java.util.Arrays;

public class Solution885 {
    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int n = rows*cols;
        int[][] res = new int[rows*cols][2];
        int resIndex = 0;
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int dIndex = 0;
        int stepLength = 1;
        int curSteps = 0;

        while(resIndex<n){
            if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols){
                res[resIndex][0] = rStart;
                res[resIndex++][1] = cStart;
            }
            //move to next position:
            rStart += directions[dIndex][0];
            cStart += directions[dIndex][1];
            //check or change direction:
            if(++curSteps==stepLength){
                //change to next direction
                dIndex++;
                dIndex = dIndex % 4;
                //increase step length by 1 every 2 directions
                if(dIndex==0 || dIndex==2) stepLength++;
                //Set curSteps to 0 after changing direction
                curSteps = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] test1 = spiralMatrixIII(1,4,0,0);
        for(int[] t:test1) System.out.print(Arrays.toString(t));
        System.out.println();
        int[][] test2 = spiralMatrixIII(5,6,1,4);
        for(int[] t:test2) System.out.print(Arrays.toString(t));
    }
}
