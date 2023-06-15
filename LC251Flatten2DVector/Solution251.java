package LC251Flatten2DVector;

public class Solution251 {
    class Vector2D {
        public int nextRow;
        public int nextCol;
        public int[][] nums;
        public Vector2D(int[][] vec) {
            nums = vec;
            nextRow = 0;
            nextCol = 0;
        }

        public int next() {
            assert hasNext();
            return nums[nextRow][nextCol++];
        }

        public boolean hasNext() {
            while(nextRow<nums.length){
                if(nextCol<nums[nextRow].length)    return true;
                else{
                    nextRow++;
                    nextCol = 0;
                }
            }
            return false;
        }
    }
}
