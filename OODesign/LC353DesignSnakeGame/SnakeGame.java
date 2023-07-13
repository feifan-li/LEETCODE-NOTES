package OODesign.LC353DesignSnakeGame;

import java.util.HashMap;
import java.util.LinkedList;

class SnakeGame {
    private int width;//列数
    private int height;//行数
    private int[][] food;
    private LinkedList<int[]> snake = new LinkedList<>();
    private HashMap<String,int[]> dirMap = new HashMap<>();
    private boolean[][] occupied;
    private int nextFood = 0;//index of next food's position

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.snake.add(0,new int[]{0,0});
        dirMap.put("R",new int[]{0,1});
        dirMap.put("D",new int[]{1,0});
        dirMap.put("L",new int[]{0,-1});
        dirMap.put("U",new int[]{-1,0});
        occupied = new boolean[height][width];
        occupied[0][0] = true;
    }

    public int move(String direction) {
        int[] head = snake.get(0);
        int[] dir = dirMap.get(direction);
        int[] nextHead = new int[]{head[0]+dir[0],head[1]+dir[1]};
        //先检查是否越界
        if(nextHead[0]<0 || nextHead[0]>=height || nextHead[1]<0 || nextHead[1]>=width)     return -1;
        //更新状态 - 两种情况：吃到 和 没食物了/没吃到
        if(nextFood<food.length && nextHead[0]==food[nextFood][0] && nextHead[1]==food[nextFood][1]){
            this.snake.add(0,nextHead);
            nextFood++;
        }else{
            this.snake.add(0,nextHead);
            int[] tail = snake.pollLast();
            occupied[tail[0]][tail[1]] = false;
        }
        //查看snake是否被更新死了
        if(occupied[nextHead[0]][nextHead[1]])  return -1;
        occupied[nextHead[0]][nextHead[1]] = true;
        return this.snake.size()-1;
    }
}
