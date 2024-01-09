package BinarySearch.LC1428LeftmostColumnWithAtLeastAOne;

public class Solution1428 {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int m = binaryMatrix.dimensions().get(0);
        int n = binaryMatrix.dimensions().get(1);
        int minCol = n;
        for(int i=0;i<m;++i){
            if(binaryMatrix.get(i,0)==1){
                return 0;
            }else{
                if(binaryMatrix.get(i,n-1)==0){
                    continue;
                }else{
                    minCol = Math.min(minCol,getLeftmostOneIndex(binaryMatrix,i,n));
                }
            }
        }
        return minCol==n?-1:minCol;
    }
    public int getLeftmostOneIndex(BinaryMatrix mat,int row,int n){
        int l = 0, r = n-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(mat.get(row,mid)==0){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l;
    }
}
