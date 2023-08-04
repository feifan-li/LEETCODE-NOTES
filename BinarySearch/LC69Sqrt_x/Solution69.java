package BinarySearch.LC69Sqrt_x;

public class Solution69 {
    public int mySqrt(int x) {
        if(x==0 || x==1)    return x;
        long l=1, r=x;
        while(l<=r){
            long mid = l +((r-l)>>1);
            if(mid*mid>x)   r = mid -1;
            else    l = mid+1;
        }
        return (int) l - 1;
    }
}
