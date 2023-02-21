package LC149MaxPointsOnALine;

import java.util.HashMap;

public class Solution149 {
    public static int maxPoints(int[][] points) {
        int res = 0;
        if(points.length==1) return 1;
        for(int i=0;i<points.length;++i){
            HashMap<String,Integer> slopeToNum = new HashMap<>();
            for(int j=0;j<points.length && j!=i;++j){
                String slope = "inf";
                if(points[i][0] != points[j][0]){
                    int ydiff = points[i][1]-points[j][1];
                    int xdiff = points[i][0]-points[j][0];
                    int gcd = gcd(ydiff,xdiff);
                    slope = (ydiff/gcd)+"/"+(xdiff/gcd);
                }
                slopeToNum.put(slope,slopeToNum.getOrDefault(slope,1)+1);
                res = Math.max(res,slopeToNum.get(slope));
            }
        }
        return res;
    }
    private static int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][]{{1,1},{2,2},{3,3}}));
        System.out.println(maxPoints(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}));

    }
}
