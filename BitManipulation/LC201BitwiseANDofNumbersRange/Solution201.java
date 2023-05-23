package BitManipulation.LC201BitwiseANDofNumbersRange;

public class Solution201 {
    public int rangeBitwiseAnd(int left, int right) {
        if(left==right || left==0)  return left;
        int a = left&right;
        int ans = 0;
        for(int i=1;i<31;++i){
            if((1&(a>>i))==1 && right-left<(1<<i)){
                ans |= (1<<i);
            }
        }
        return ans;
    }
}
