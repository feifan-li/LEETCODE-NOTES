package Greedy.LC365WaterAndJugProblem;

public class Solution365 {
    public boolean canMeasureWater(int jug1, int jug2, int target) {
        if(jug1+jug2<target)    return false;
        if(jug1==target || jug2==target || jug1+jug2==target || Math.abs(jug1-jug2)==target)    return true;
        return target%gcd(jug1,jug2)==0;
    }
    public int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}
