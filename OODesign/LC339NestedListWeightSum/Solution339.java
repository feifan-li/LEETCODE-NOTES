package OODesign.LC339NestedListWeightSum;

import java.util.List;

public class Solution339 {
    public int ans = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        for(NestedInteger ni:nestedList)    helper(ni,1);
        return ans;
    }
    public void helper(NestedInteger ni,int depth){
        if(ni.isInteger()){
            ans += ni.getInteger()*depth;
            return;
        }
        List<NestedInteger> nestedList = ni.getList();
        for(NestedInteger nii:nestedList)    helper(nii,depth+1);
    }
}
