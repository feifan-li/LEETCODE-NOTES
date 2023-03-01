package Backtrack.LC489RobotRoomCleaner;

import java.util.HashSet;
import java.util.Set;

public class Solution489 {
     // This is the robot's control interface.
     // You should not implement it, or speculate about its implementation
     interface Robot {
      // Returns true if the cell in front is open and robot moves into the cell.
      // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();
        public void turnRight();
        // Clean the current cell.
        public void clean();
     }
    Set<Integer> visited = new HashSet<>();//the coordinates here are relative
    int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    Robot robot;
    public void cleanRoom(Robot robot) {
        this.robot = robot;
        dfs(0,0,0);//start from relative (0,0),start with facing up(0)
    }
    private void back(){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }
    public void dfs(int row,int col,int direction){
        visited.add((row+100)*200+col+200);
        robot.clean();
        for(int i=0;i<4;++i){
            int newDirection = (direction+i)%4;
            int newRow = row+directions[newDirection][0];
            int newCol = col+directions[newDirection][1];
            if(!visited.contains((newRow+100)*200+newCol+200) && robot.move()){
                dfs(newRow,newCol,newDirection);
                back();
            }
            robot.turnRight();
        }
    }
}
