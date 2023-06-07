package BitManipulation.LC1318MinFlipsToMakeaORbEqualToc;

public class Solution1318 {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for(int i=0;i<32;++i){
            if((((a>>i)&1)|((b>>i)&1))==((c>>i)&1)){
                continue;
            }else if(((c>>i)&1)==1){
                ans += 1;
            }else if(((a>>i)&1)==1 && ((b>>i)&1)==1){
                ans += 2;
            }else{
                ans += 1;
            }
        }
        return ans;
    }
}
