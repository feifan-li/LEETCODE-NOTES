package DynamicProgramming.LC256PaintHouse;

public class Solution256 {
    public int minCost(int[][] costs) {
        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];
        for(int i=1;i<costs.length;++i){
            int prev_red = red, prev_blue = blue, prev_green = green;
            red = costs[i][0] + Math.min(prev_blue,prev_green);
            blue = costs[i][1] + Math.min(prev_red,prev_green);
            green = costs[i][2] + Math.min(prev_red,prev_blue);
        }
        return Math.min(red,Math.min(blue,green));
    }
}
