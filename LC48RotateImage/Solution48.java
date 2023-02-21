package LC48RotateImage;

public class Solution48 {
    public static void rotate(int[][] matrix) {
        int n= matrix.length;
        for(int i=0;i<n;++i){
            for(int j=i;j<n;++j){
                int tmp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
        for(int i=0;i<n;++i){
            for(int j=0;j<=(n-1)/2;++j){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
        System.out.println("-------");
        System.out.println("After Rotating:");
    }
    public static void printArray(int[][] arr){
        for(int i=0;i<arr.length;++i){
            for(int j=0;j<arr[0].length;++j){
                System.out.print(arr[i][j]+"   ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] test1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        printArray(test1);
        rotate(test1);
        printArray(test1);

        System.out.println("-------");
        int[][] test2 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printArray(test2);
        rotate(test2);
        printArray(test2);
    }
}
