package LC1232CheckIfItIsAStraightLine;

public class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int deltaX = coordinates[0][0] - coordinates[1][0];
        int deltaY = coordinates[0][1] - coordinates[1][1];
        for(int i=2;i<coordinates.length;++i){
            int curDeltaX = coordinates[i-1][0] - coordinates[i][0];
            int curDeltaY = coordinates[i-1][1] - coordinates[i][1];
            if(deltaY*curDeltaX!=deltaX*curDeltaY){
                return false;
            }
        }
        return true;
    }
}
