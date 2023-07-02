package BinarySearch.LC302SmallestRectangleEnclosingBlackPixels;

public class Solution302 {
    public int minArea(char[][] image, int x, int y) {
        int left = binarySearchLeft(image,0,y);
        int right = binarySearchRight(image,y,image[0].length-1);
        int top = binarySearchTop(image,0,x);
        int down = binarySearchDown(image,x,image.length-1);
        return (down-top+1)*(right-left+1);
    }
    public int binarySearchLeft(char[][] image,int left,int right){
        while(left<=right){
            int mid = left+(right-left)/2;
            if(emptyCol(image,mid)){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
    public int binarySearchRight(char[][] image,int left,int right){
        while(left<=right){
            int mid = left+(right-left)/2;
            if(emptyCol(image,mid)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return right;
    }
    public int binarySearchTop(char[][] image,int left,int right){
        while(left<=right){
            int mid = left+(right-left)/2;
            if(emptyRow(image,mid)){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
    public int binarySearchDown(char[][] image,int left,int right){
        while(left<=right){
            int mid = left+(right-left)/2;
            if(emptyRow(image,mid)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return right;
    }
    public boolean emptyCol(char[][] image,int col){
        int sum = 0;
        for(int i=0;i<image.length;++i){
            sum += (image[i][col]-'0');
        }
        return sum==0;
    }
    public boolean emptyRow(char[][] image,int row){
        int sum = 0;
        for(int i=0;i<image[0].length;++i){
            sum += (image[row][i]-'0');
        }
        return sum==0;
    }
}
