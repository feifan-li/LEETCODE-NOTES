package LC390EliminationGame;

public class Solution390 {
    public int lastRemaining(int n) {
        int dir = 0,remain = n,halfStride = 1, left = 1;
        while(remain>1){
            if(dir==0 || remain%2==1)   left += halfStride;
            remain = remain>>1;
            halfStride = halfStride<<1;
            dir ^= 1;
        }
        return left;
    }
}
